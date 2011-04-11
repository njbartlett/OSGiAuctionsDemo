package org.example.auction;


import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import java.util.List;

/**
 * @model
 * @author Neil Bartlett
 *
 */
public interface AuctionItem extends EObject {
	/**
	 * @model
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.example.auction.AuctionItem#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * @model opposite="auctionItem"
	 * @return
	 */
	EList<Bid> getBids();
	
	/**
	 * @model
	 * @return
	 */
	Date getExpiryDate();
	
	/**
	 * Sets the value of the '{@link org.example.auction.AuctionItem#getExpiryDate <em>Expiry Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expiry Date</em>' attribute.
	 * @see #getExpiryDate()
	 * @generated
	 */
	void setExpiryDate(Date value);

	/**
	 * @model
	 * @return
	 */
	long getStartingPrice();

	/**
	 * Sets the value of the '{@link org.example.auction.AuctionItem#getStartingPrice <em>Starting Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starting Price</em>' attribute.
	 * @see #getStartingPrice()
	 * @generated
	 */
	void setStartingPrice(long value);

}