package name.njbartlett.osgi.vaadin.util;
import java.util.IdentityHashMap;
import java.util.Map;

import org.osgi.service.component.ComponentFactory;
import org.osgi.service.component.ComponentInstance;

import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

public class DynamicTabSheet extends ConcurrentComponent {
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("rawtypes")
	private final SelectionSupport selectionSupport;
	private final Map<ComponentFactory, ComponentInstance> componentInstanceMap = new IdentityHashMap<ComponentFactory, ComponentInstance>();
	private final Map<ComponentFactory, Component> tabMap = new IdentityHashMap<ComponentFactory, Component>();
	
	private final TabSheet tabs = new TabSheet();
	
	private String lastTabName = null;
	
	public DynamicTabSheet() {
		this(null);
	}

	public DynamicTabSheet(SelectionSupport<?> selectionSupport) {
		this.selectionSupport = selectionSupport;
	}
	
	@Override
	public void attach() {
		super.attach();
		setCompositionRoot(tabs);
	}
	
	/**
	 * <p>
	 * Inject a contribution component factory. Example use with Declarative
	 * Services (Bnd annotations):
	 * </p>
	 * 
	 * <p>
	 * {@code @Reference(type = '*', target = "(component.factory=com.vaadin.Component/contribution)")}
	 * </p>
	 * 
	 * @param factory
	 */
	public void bindTab(ComponentFactory factory) {
		try {
			ComponentInstance ci = factory.newInstance(null);
			Object o = ci.getInstance();
			if (o != null && o instanceof Component) {
				Component c = (Component) o;
				synchronized (synchronizer()) {
					addTab(c);
					tabMap.put(factory, c);
					componentInstanceMap.put(factory, ci);
					
					if (lastTabName != null && lastTabName.equals(c.getCaption())) {
						tabs.setSelectedTab(c);
						lastTabName = null;
					}
				}
			} else {
				ci.dispose();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addTab(Component component) {
		tabs.addTab(component);
		if (selectionSupport != null && component instanceof SelectionListener) {
			SelectionListener listener = (SelectionListener) component;
			selectionSupport.addSelectionListener(listener);
		}
	}
	
	public void unbindTab(ComponentFactory factory) {
		ComponentInstance ci;
		Component c;
		
		synchronized (synchronizer()) {
			ci = componentInstanceMap.remove(factory);
			c = tabMap.remove(factory);
			if (c != null) {
				if (c == tabs.getSelectedTab())
					lastTabName = c.getCaption();
				
				removeTab(c);
				c.detach();
			}
		}
		
		if (ci != null)
			ci.dispose();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void removeTab(Component component) {
		tabs.removeComponent(component);
		if (selectionSupport != null && component instanceof SelectionListener) {
			SelectionListener listener = (SelectionListener) component;
			selectionSupport.removeSelectionListener(listener);
		}
	}
	
}