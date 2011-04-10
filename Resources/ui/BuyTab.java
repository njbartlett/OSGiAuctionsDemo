package org.example.auction.ui.buy;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

import name.njbartlett.osgi.vaadin.util.ConcurrentComponent;
import name.njbartlett.osgi.vaadin.util.SelectionListener;

import org.example.auction.AuctionFactory;
import org.example.auction.AuctionItem;
import org.example.auction.Bid;
import org.example.auction.IAuctionService;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.IntegerValidator;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

@aQute.bnd.annotation.component.Component(factory = "com.vaadin.Component/auctionTab")
public class BuyTab extends ConcurrentComponent implements SelectionListener<IAuctionService> {
	
	private final AtomicReference<IAuctionService> auctionSvcRef = new AtomicReference<IAuctionService>();
	
	private final BeanItemContainer<AuctionItem> items = new BeanItemContainer<AuctionItem>(AuctionItem.class);
	private final BeanItemContainer<Bid> bids = new BeanItemContainer<Bid>(Bid.class);

	private final Button bidButton = new Button("Place Bid");
	private TextField txtBidAmount;
	private Table itemsTable;
	private Table bidsTable;
	
	private AuctionItem selectedAuctionItem;
	
	
	public BuyTab() {
		setCaption("Buy");
		setCompositionRoot(createMainComponent());
	}
	
	private Component createMainComponent() {
		HorizontalLayout mainLayout = new HorizontalLayout();
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		
		itemsTable = new Table("Items", items);
		itemsTable.setSelectable(true);
		itemsTable.setImmediate(true);
		itemsTable.setVisibleColumns(new Object[] { "description", "startingPrice" });
		itemsTable.setColumnHeaders(new String[] { "Description", "Starting Price" });
		itemsTable.setWidth("300px");
		itemsTable.setHeight("100%");
		mainLayout.addComponent(itemsTable);

		VerticalLayout bidsPanel = new VerticalLayout();
		bidsPanel.setSpacing(true);
		bidsTable = new Table("Bids", bids);
		bidsTable.setSelectable(false);
		bidsTable.setImmediate(true);
		bidsTable.setVisibleColumns(new Object[] { "price", "userId", "date" });
		bidsTable.setColumnHeaders(new String[] { "Price", "User", "Date/Time" });
		bidsTable.setWidth("300px");
		bidsPanel.addComponent(bidsTable);
		
		bidButton.setWidth("100%");
		bidButton.setEnabled(false);
		bidsPanel.addComponent(bidButton);
		bidsPanel.setComponentAlignment(bidButton, Alignment.MIDDLE_CENTER);
		mainLayout.addComponent(bidsPanel);
		
		final Window bidWindow = new Window("Place Bid");
		bidWindow.setModal(true);
		createBidWindowContent(bidWindow);
		
		// Listeners
		itemsTable.addListener(new ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				Object itemId = itemsTable.getValue();
				BeanItem<AuctionItem> beanItem = items.getItem(itemId);
				setSelectedItem(beanItem != null ? beanItem.getBean() : null);
			}
		});
		
		bidButton.addListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				bidWindow.setWidth("300px");
				bidWindow.setHeight("200px");
 				getApplication().getMainWindow().addWindow(bidWindow);
 				
 				txtBidAmount.setValue("");
 				txtBidAmount.focus();
			}
		});
		return mainLayout;
	}
	
	private void createBidWindowContent(final Window parentWindow) {
		parentWindow.setCloseShortcut(KeyCode.ESCAPE);
		
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		mainLayout.setSizeFull();
		
		txtBidAmount = new TextField("Enter Bid Amount:");
		IntegerValidator bidAmountValidator = new IntegerValidator("Not valid");
		txtBidAmount.addValidator(bidAmountValidator);
		txtBidAmount.setImmediate(true);
		txtBidAmount.setValidationVisible(true);
		txtBidAmount.setWidth("100%");
		mainLayout.addComponent(txtBidAmount);
		
		HorizontalLayout buttonBar = new HorizontalLayout();
		buttonBar.setSizeFull();
		Button btnCancel = new Button("Cancel");
		buttonBar.addComponent(btnCancel);
		buttonBar.setComponentAlignment(btnCancel, Alignment.MIDDLE_CENTER);
		
		final Button btnPlaceBid = new Button("BID");
		btnPlaceBid.setClickShortcut(KeyCode.ENTER);
		btnPlaceBid.addStyleName("primary");
		
		buttonBar.addComponent(btnPlaceBid);
		buttonBar.setComponentAlignment(btnPlaceBid, Alignment.MIDDLE_CENTER);
		mainLayout.addComponent(buttonBar);
		
		parentWindow.addComponent(mainLayout);
		
		btnCancel.addListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				getApplication().getMainWindow().removeWindow(parentWindow);
			}
		});
		btnPlaceBid.addListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				String value = (String) txtBidAmount.getValue();
				if (txtBidAmount.isValid() && value != null && value.length() > 0) {
					IAuctionService auctionService = auctionSvcRef.get();
					if (auctionService != null) {
						Bid bid = AuctionFactory.eINSTANCE.createBid();

						bid.setPrice(Long.parseLong(value));
						bid.setUserId("me");
						selectedAuctionItem.getBids().add(bid);
						
						getApplication().getMainWindow().removeWindow(parentWindow);
					} else {
						showError("Auction service not available.");
					}
				}
			}
		});
	}
	
	void setSelectedItem(AuctionItem auctionItem) {
		this.selectedAuctionItem  = auctionItem;
		
		bidButton.setEnabled(auctionItem != null);
		bids.removeAllItems();
		
		if (auctionItem != null) for (Bid bid : auctionItem.getBids()) {
			bids.addBean(bid);
		}
	}
	
	void setAuctionService(final IAuctionService service) {
		auctionSvcRef.set(service);
		executeUpdate(new Runnable() {
			public void run() {
				items.removeAllItems();
				
				AuctionItem firstItem = null;
				if (service != null) {
					Collection<AuctionItem> newItems = service.listAuctionItems();
					for (AuctionItem item : newItems) {
						if (firstItem == null) firstItem = item;
						items.addBean(item);
					}
				}
				
				setSelectedItem(firstItem);
				itemsTable.select(firstItem);
			}
		});
	}

	
	void showError(String message) {
		getApplication().getMainWindow().showNotification(message, Notification.TYPE_ERROR_MESSAGE);
	}


	@Override
	public void selectionChanged(IAuctionService selection) {
		setAuctionService(selection);
	}
}
