package name.njbartlett.osgi.vaadin.util;

import com.vaadin.Application;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;

public abstract class ConcurrentComponent extends CustomComponent {

	private static final long serialVersionUID = 1L;

	@Override
	public synchronized void setParent(Component parent) {
		super.setParent(parent);
	}
	
	@Override
	public synchronized Component getParent() {
		return super.getParent();
	}
	
	protected Object synchronizer() {
		Application application = getApplication();
		
		return application != null ? application : this;
	}
	
	protected void executeUpdate(Runnable update) {
		Object lock = synchronizer();
		synchronized (lock) {
			update.run();
		}
	}
}
