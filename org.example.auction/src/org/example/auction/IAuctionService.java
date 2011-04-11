package org.example.auction;

import java.io.IOException;
import java.util.Collection;

public interface IAuctionService {

	/**
	 * Insert a new item into the auction.
	 * @param item The item to insert
	 * @return The ID of the item
	 * @throws IOException
	 */
	String insertAuctionItem(AuctionItem item) throws IOException;
	
	/**
	 * Find an item by its ID
	 * @param id The item ID
	 * @return The matching item, or null.
	 */
	AuctionItem findItem(String id);
	
	/**
	 * Get a list of all current items in the auction.
	 * @return
	 */
	Collection<AuctionItem> listAuctionItems();

}