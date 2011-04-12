package org.example.auction.ui.sell;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@aQute.bnd.annotation.component.Component(factory = "com.vaadin.Component/auctionTab")
public class SellTab extends CustomComponent {
	
	private final TextField txtDescription = new TextField("Item Description");
	private final TextField txtPrice = new TextField("Starting Price");
	private final Button btnSell = new Button("Sell");
	
	public SellTab() {
		setCaption("Sell");
	}
	
	@Override
	public void attach() {
		super.attach();
		setCompositionRoot(createPanel());
	}

	Component createPanel() {
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);
		layout.addComponent(txtDescription);
		layout.addComponent(txtPrice);
		layout.addComponent(btnSell);
		return layout;
	}
}