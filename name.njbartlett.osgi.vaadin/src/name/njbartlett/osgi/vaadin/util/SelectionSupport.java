package name.njbartlett.osgi.vaadin.util;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;


public class SelectionSupport<T> {
	
	private final AtomicReference<T> currentSelection = new AtomicReference<T>(null);
	private final List<SelectionListener<? super T>> listeners = new CopyOnWriteArrayList<SelectionListener<? super T>>();
	
	public void setSelection(T selection) {
		Iterator<SelectionListener<? super T>> iterator;
		
		synchronized (listeners) {
			iterator = listeners.iterator();
			currentSelection.set(selection);
		}
		
		while (iterator.hasNext())
			iterator.next().selectionChanged(selection);
	}
	
	public void addSelectionListener(SelectionListener<? super T> listener) {
		T selectionValue;
		
		synchronized (listeners) {
			selectionValue = currentSelection.get();
			listeners.add(listener);
		}
		
		listener.selectionChanged(selectionValue);
	}
	
	public void removeSelectionListener(SelectionListener<? super T> listener) {
		listeners.remove(listener);
	}
	
}
