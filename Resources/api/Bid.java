package org.example.auction;

import java.util.Date;

import org.example.auction.AuctionItem;

/**
 * @model
 * @author Neil Bartlett
 *
 */
public interface Bid {

	/**
	 * @model
	 * @return
	 */
	long getPrice();

	/**
	 * @model
	 * @return
	 */
	Date getDate();
	/**
	 * @model
	 * @return
	 */
	String getUserId();
	
	/**
	 * @model opposite="bids"
	 * @return
	 */
	AuctionItem getAuctionItem();
	
}