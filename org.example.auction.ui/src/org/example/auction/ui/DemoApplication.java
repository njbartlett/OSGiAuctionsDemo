package org.example.auction.ui;

import java.util.Map;

import org.example.auction.IAuctionService;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

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

	@Reference(type = '*')
	public void addAuction(IAuctionService auction,
			Map<String, Object> properties) {
		auctionListPanel.addAuction(auction, properties);
	}

	public void removeAuction(IAuctionService auction) {
		auctionListPanel.removeAuction(auction);
	}
	
	

}