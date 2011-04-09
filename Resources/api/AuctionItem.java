package org.example.auction;


import java.util.Date;
import java.util.List;

/**
 * @model
 * @author Neil Bartlett
 *
 */
public interface AuctionItem {
	/**
	 * @model
	 */
	String getDescription();

	/**
	 * @model opposite="auctionItem"
	 * @return
	 */
	List<Bid> getBids();
	
	/**
	 * @model
	 * @return
	 */
	Date getExpiryDate();
	
	/**
	 * @model
	 * @return
	 */
	long getStartingPrice();

}