package name.njbartlett.osgi.vaadin;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.service.http.HttpContext;

final class VaadinHttpContext implements HttpContext {
	
	private final Bundle vaadinBundle;

	public VaadinHttpContext(Bundle vaadinBundle) {
		this.vaadinBundle = vaadinBundle;
	}
	public boolean handleSecurity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return true;
	}

	public URL getResource(String name) {
		return vaadinBundle.getResource(name);
	}

	public String getMimeType(String name) {
		return null;
	}
}