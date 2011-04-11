package org.example.auction.ui;

import aQute.bnd.annotation.component.Component;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@Component(factory = "com.vaadin.Application/auction")
public class DemoApplication extends Application {

	@Override
	public void init() {
		VerticalLayout layout = new VerticalLayout();
		Label label = new Label("Hello World");
		layout.addComponent(label);

		setMainWindow(new Window("Demo App", layout));
	}

}