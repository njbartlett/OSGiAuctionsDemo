package org.example.auction.ui.sell;

import java.io.IOException;

import name.njbartlett.osgi.vaadin.util.SelectionListener;

import org.example.auction.AuctionFactory;
import org.example.auction.AuctionItem;
import org.example.auction.IAuctionService;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;

@aQute.bnd.annotation.component.Component(factory = "com.vaadin.Component/auctionTab")
public class SellTab extends CustomComponent implements SelectionListener<IAuctionService> {
	
	private final TextField txtDescription = new TextField("Item Description");
	private final TextField txtPrice = new TextField("Starting Price");
	private final Button btnSell = new Button("Sell");
	
	private IAuctionService selectedAuction;
	
	public SellTab() {
		setCaption("Sell");
		
		btnSell.setEnabled(false);
		btnSell.addListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				AuctionItem item = AuctionFactory.eINSTANCE.createAuctionItem();
				item.setDescription((String) txtDescription.getValue());
				item.setStartingPrice(Long.parseLong((String) txtPrice.getValue()));
				try {
					selectedAuction.insertAuctionItem(item);
					getApplication().getMainWindow().showNotification("Auction item saved.");
				} catch (IOException e) {
					getApplication().getMainWindow().showNotification("Error", e.getLocalizedMessage(), Notification.TYPE_ERROR_MESSAGE);
				}
			}
		});
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

	@Override
	public void selectionChanged(IAuctionService selection) {
		selectedAuction = selection;
		btnSell.setEnabled(selection != null);
	}
}