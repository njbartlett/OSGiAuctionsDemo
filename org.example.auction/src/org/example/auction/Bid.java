package org.example.auction;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.example.auction.AuctionItem;

/**
 * @model
 * @author Neil Bartlett
 *
 */
public interface Bid extends EObject {

	/**
	 * @model
	 * @return
	 */
	long getPrice();

	/**
	 * Sets the value of the '{@link org.example.auction.Bid#getPrice <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Price</em>' attribute.
	 * @see #getPrice()
	 * @generated
	 */
	void setPrice(long value);

	/**
	 * @model
	 * @return
	 */
	Date getDate();
	/**
	 * Sets the value of the '{@link org.example.auction.Bid#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * @model
	 * @return
	 */
	String getUserId();
	
	/**
	 * Sets the value of the '{@link org.example.auction.Bid#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @see #getUserId()
	 * @generated
	 */
	void setUserId(String value);

	/**
	 * @model opposite="bids"
	 * @return
	 */
	AuctionItem getAuctionItem();

	/**
	 * Sets the value of the '{@link org.example.auction.Bid#getAuctionItem <em>Auction Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auction Item</em>' reference.
	 * @see #getAuctionItem()
	 * @generated
	 */
	void setAuctionItem(AuctionItem value);
	
}