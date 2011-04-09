package name.njbartlett.osgi.vaadin;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.ComponentFactory;
import org.osgi.service.component.ComponentInstance;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import aQute.bnd.annotation.component.Reference;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;

/**
 * This is an activator bundles with the Vaadin code to simplify the use of
 * Vaadin in OSGi.
 * 
 * This component tracks one or more Http Services. For each Application
 * component factory that is available, it will register an Application Servlet
 * (local class) with that Http Service. The Application Servlet will create
 * instances on demand. If Component Factory services or Http Services are
 * unregistered, the data structures are cleaned up. For this reason we have to
 * maintain a shadow registry of the OSGi Http Service registrations as well as
 * all registered component factories.
 * 
 * This class uses 'this' as the lock object.
 * 
 * @author Peter Kriens
 */

@aQute.bnd.annotation.component.Component
public class VaadinOSGiManager {
	
	final BundleContext context = FrameworkUtil.getBundle(VaadinOSGiManager.class).getBundleContext();
	final Bundle vaadinBundle = FrameworkUtil.getBundle(Application.class);

	final Map<HttpService, Map<String, ApplicationServlet>> https = new HashMap<HttpService, Map<String, ApplicationServlet>>();
	final Map<String, ComponentFactory> apps = new IdentityHashMap<String, ComponentFactory>();

	/**
	 * This is our dependency on the HttpService. There can be multiple HTTP
	 * services in an OSGi framework.
	 * 
	 * @param http
	 *            the new Http Service.
	 * @throws Exception
	 *             When anything goes wrong (so it can be logged in DS)
	 */
	@Reference(type = '*')
	protected void setHttp(HttpService http) throws Exception {
		// Configure the Http Service so it properly loads
		// resources.
		configure(http);

		// We can mix registrations/unregistrations of
		// apps and http services so we should properly lock
		// not nice that we hold the lock for register
		// but the related callbacks are likely very tiny
		// and only updating data structures because no
		// actual app is needed.
		synchronized (this) {

			// Create new entry for this http service with an empty registration
			// map
			https.put(http, new HashMap<String, ApplicationServlet>());

			// Ensure all current apps are registered with this http service.
			for (Map.Entry<String, ComponentFactory> entry : apps.entrySet()) {
				register(http, entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * An Http Service is unregistered.
	 * 
	 * We remove the http service from our map and close all registered
	 * Application Servlets. The close is done outside the lock.
	 * 
	 * @param http
	 *            The http service.
	 */
	protected void unsetHttp(HttpService http) {
		Collection<ApplicationServlet> toBeDestroyed;
		synchronized (this) {
			toBeDestroyed = https.remove(http).values();
		}

		for (ApplicationServlet servlet : toBeDestroyed) {
			servlet.close();
		}
	}

	/**
	 * Add a new application.
	 * 
	 * Each application is a DS component that is a factory. The factory id must
	 * be com.vaadin.Application/&lt;alias&gt;, where &lt;alias&gt; is the the
	 * URI of the application.
	 * 
	 * @param factory
	 *            The service, which must be a Component Factory
	 * @param properties
	 *            The component factory service properties
	 * @throws ServletException
	 * @throws NamespaceException
	 */

	@Reference(type = '*', target = "(component.factory=com.vaadin.Application/*)")
	protected void addApplication(ComponentFactory factory,
			Map<String, String> properties) throws ServletException,
			NamespaceException {
		String alias = getAlias(properties);
		synchronized (this) {
			apps.put(alias, factory);

			// Ensure all https get this app
			for (HttpService http : https.keySet()) {
				System.out.println("Registering Vaadin app at alias: " + alias);
				register(http, alias, factory);
			}
		}
	}

	/**
	 * Remove an application. Make sure all https that hold this application
	 * have it unregistered and close all application servlets.
	 * 
	 * @param factory
	 *            The service
	 * @param properties
	 *            The component factory service properties
	 */
	protected void removeApplication(ComponentFactory factory, Map<String, String> properties) {
		String alias = getAlias(properties);
		Set<ApplicationServlet> toBeDestroyed = new HashSet<ApplicationServlet>();

		synchronized (this) {
			for (HttpService http : https.keySet()) {
				System.out.println("Unregistering Vaadin app at alias: " + alias);
				http.unregister(alias);
				Map<String, ApplicationServlet> map = https.get(http);
				toBeDestroyed.add(map.remove(alias));
			}
		}
		for (ApplicationServlet servlet : toBeDestroyed) {
			servlet.close();
		}
	}

	/*
	 * Calculate the alias. No check is done because these properties must come
	 * from a component factory.
	 * 
	 * The component.name is expected to be of the form:
	 * <code>com.vaadin.Application/&lt;alias&gt;</code>
	 * 
	 * @param properties The properties from the component factory service
	 * 
	 * @return the alias part.
	 */
	private String getAlias(Map<String, String> properties) {
		String alias = properties.get("component.factory");
		int n = alias.indexOf('/');
		alias = alias.substring(n);
		return alias;
	}

	/**
	 * Utility to register an Application Servlet with an Http Service.
	 * 
	 * @param http
	 *            The Http Service
	 * @param alias
	 *            The name under which to register
	 * @param factory
	 *            The factory to be used
	 * @throws ServletException
	 * @throws NamespaceException
	 */
	private void register(final HttpService http, String alias,
			final ComponentFactory factory) throws ServletException,
			NamespaceException {
		ApplicationServlet s = new ApplicationServlet(factory);
		synchronized (this) {
			https.get(http).put(alias, s);
		}
		http.registerServlet(alias, s, null, new VaadinHttpContext(vaadinBundle));
	}

	/**
	 * Ensures that the resources in this bundle are available. Maps the VAADIN
	 * resource tree to the web server under /VAADIN. This way the resources
	 * does not have to be exported.
	 * 
	 * @param http
	 *            The Http Service
	 * @throws NamespaceException
	 */
	private void configure(HttpService http) throws NamespaceException {
		http.registerResources("/VAADIN", "VAADIN", new VaadinHttpContext(vaadinBundle));
	}

	/**
	 * A servlet that acts as the factory for new instances for Vaadin.
	 * 
	 * The servlet extends AbstractApplicationServlet as defined by Vaadin. For
	 * each application, it will request a new instance. If this servlet is
	 * closed, all created instances will be disposed.
	 * 
	 */
	class ApplicationServlet extends AbstractApplicationServlet {
		private static final long serialVersionUID = 1L;

		final ComponentFactory factory;
		final Set<ComponentInstance> instances = new HashSet<ComponentInstance>();
		final Set<Application> applications = new HashSet<Application>();
		final AtomicBoolean open = new AtomicBoolean(true);

		ApplicationServlet(ComponentFactory factory) {
			this.factory = factory;
		}

		@Override
		protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
			return Application.class;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected Application getNewApplication(HttpServletRequest request)
				throws ServletException {
			if (open.get()) {
				Hashtable<String, Object> ht = new Hashtable<String, Object>();
				for (Enumeration<String> e = request.getAttributeNames(); e.hasMoreElements();) {
					String key = e.nextElement();
					ht.put(key, request.getAttribute(key));
				}
				ComponentInstance instance = factory.newInstance(ht);
				Application application = (Application) instance.getInstance();
				synchronized (this) {
					instances.add(instance);
					applications.add(application);
					return application;
				}
			} else
				throw new IllegalStateException("Application Servlet is closed! " + factory);
		}

		public void close() {
			if (open.getAndSet(false)) {
				synchronized (this) {
					for (Application application : applications) {
						application.close();
					}
					applications.clear();
					for (ComponentInstance instance : instances) {
						instance.dispose();
					}
					instances.clear();
				}
			}
		}
	}
}
