package org.example.auction.ui;

import java.util.Map;

import name.njbartlett.osgi.vaadin.util.DynamicTabSheet;

import org.example.auction.IAuctionService;
import org.osgi.service.component.ComponentFactory;

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
	private final DynamicTabSheet tabs = new DynamicTabSheet();

	@Override
	public void init() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		layout.addComponent(createBanner());
		
		HorizontalLayout main = new HorizontalLayout();
		main.setSpacing(true);
		main.setSizeFull();
		layout.addComponent(main);
		main.addComponent(auctionListPanel);
		main.setExpandRatio(auctionListPanel, .3f);
		main.addComponent(tabs);
		main.setExpandRatio(tabs, .7f);

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

	@Reference(type = '*', target = "(component.factory=com.vaadin.Component/auctionTab)")
	public void bindTab(ComponentFactory factory) {
		tabs.bindTab(factory);
	}

	public void unbindTab(ComponentFactory factory) {
		tabs.unbindTab(factory);
	}
	
	

}