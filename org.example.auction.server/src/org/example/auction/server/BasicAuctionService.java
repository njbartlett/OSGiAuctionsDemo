package org.example.auction.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.example.auction.AuctionFactory;
import org.example.auction.AuctionItem;
import org.example.auction.IAuctionService;

import aQute.bnd.annotation.component.Component;

@Component(properties = {"label=Basic"})
public class BasicAuctionService implements IAuctionService {

	private final List<AuctionItem> items;
	
	public BasicAuctionService() {
		items = new ArrayList<AuctionItem>();
		
		AuctionItem item;
		
		item = AuctionFactory.eINSTANCE.createAuctionItem();
		item.setDescription("Foil hat");
		item.setStartingPrice(100);
		items.add(item);
		
		item = AuctionFactory.eINSTANCE.createAuctionItem();
		item.setDescription("Golden party badge no 1");
		item.setStartingPrice(1000000);
		items.add(item);
	}

	@Override
	public String insertAuctionItem(AuctionItem item) throws IOException {
		String id = Integer.toString(items.size());
		items.add(item);
		return id;
	}

	@Override
	public AuctionItem findItem(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<AuctionItem> listAuctionItems() {
		return Collections.unmodifiableList(items);
	}
	
}