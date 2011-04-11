package org.example.auction.ui;

import aQute.bnd.annotation.component.Component;

import com.vaadin.Application;
import com.vaadin.terminal.ClassResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@Component(factory = "com.vaadin.Application/auction")
public class DemoApplication extends Application {
	
	private final AuctionListPanel auctionListPanel = new AuctionListPanel();

	@Override
	public void init() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		
		layout.addComponent(createBanner());
		layout.addComponent(auctionListPanel);
		
		setMainWindow(new Window("Demo App", layout));
	}
	
	private com.vaadin.ui.Component createBanner() {
		HorizontalLayout layout = new HorizontalLayout();
		
		Embedded image = new Embedded(null, new ClassResource("banner.png", this));
		image.setHeight("100px");
		layout.addComponent(image);
		
		return layout;
	}

}