package org.example.auction.ui;

import aQute.bnd.annotation.component.Component;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;

@Component(factory = "com.vaadin.Component/auctionTab")
public class DemoTab extends CustomComponent {
	public DemoTab() {
		setCaption("Demo");
		setCompositionRoot(new Label("Hello"));
	}
}
