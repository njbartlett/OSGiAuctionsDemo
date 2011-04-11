package org.example.auction.ui;

import java.util.Map;

import name.njbartlett.osgi.vaadin.util.ConcurrentComponent;
import name.njbartlett.osgi.vaadin.util.SelectionSupport;

import org.example.auction.IAuctionService;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class AuctionListPanel extends ConcurrentComponent {
	
	private static final long serialVersionUID = 1L;
	private static final String PID_AUCTION_REF = "auctionRef";
	private static final String PID_NAME = "name";
	
	private final Container auctions;
	
	private final Table table;
	private final VerticalLayout mainPanel;
	
	private IAuctionService selection = null;
	
	public AuctionListPanel() {
		this(null);
	}
	
	public AuctionListPanel(final SelectionSupport<IAuctionService> selectionSupport) {
		auctions = new IndexedContainer();
		auctions.addContainerProperty(PID_NAME, String.class, null);
		auctions.addContainerProperty(PID_AUCTION_REF, IAuctionService.class, null);
		
		table = new Table(null, auctions);
		table.setVisibleColumns(new Object[] { PID_NAME });
		table.setColumnHeader(PID_NAME, "Auctions");
		table.setSelectable(true);
		table.setImmediate(true);

		ProgressIndicator progress = new ProgressIndicator();
		progress.setCaption("Polling...");
		progress.setIndeterminate(true);
		progress.setPollingInterval(3000);
		
		table.setSizeFull();
		mainPanel = new VerticalLayout();
		mainPanel.setSpacing(true);
		mainPanel.addComponent(table);
		mainPanel.addComponent(progress);
		
		table.addListener(new Property.ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				Object itemId = table.getValue();
				Item item = table.getItem(itemId);
				
				selection = item != null ? (IAuctionService) item.getItemProperty(PID_AUCTION_REF).getValue() : null;
			
				if (selectionSupport != null)
					selectionSupport.setSelection(selection);
			}
		});
		setCompositionRoot(mainPanel);
	}
	
	public void addAuction(IAuctionService auction, Map<String, Object> properties) {
		addAuction(auction, (String) properties.get("label"));
	}
	
	public void addAuction(final IAuctionService auction, final String caption) {
		executeUpdate(new Runnable() {
			public void run() {
				Item item = auctions.addItem(System.identityHashCode(auction));
				item.getItemProperty(PID_AUCTION_REF).setValue(auction);
				item.getItemProperty(PID_NAME).setValue(caption != null ? caption : "<anonymous>");
			}
		});
	}

	public void removeAuction(IAuctionService auction) {
		final int itemId = System.identityHashCode(auction);
		executeUpdate(new Runnable() {
			public void run() {
				auctions.removeItem(itemId);
				
				Object value = table.getValue();
				if (value != null && itemId == (Integer) value) {
					table.setValue(null);
				}
			}
		});
	}
}
