/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.auction.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.example.auction.AuctionItem;
import org.example.auction.AuctionPackage;
import org.example.auction.Bid;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.auction.impl.BidImpl#getPrice <em>Price</em>}</li>
 *   <li>{@link org.example.auction.impl.BidImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.example.auction.impl.BidImpl#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.example.auction.impl.BidImpl#getAuctionItem <em>Auction Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BidImpl extends EObjectImpl implements Bid {
	/**
	 * The default value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected static final long PRICE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected long price = PRICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected String userId = USER_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAuctionItem() <em>Auction Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuctionItem()
	 * @generated
	 * @ordered
	 */
	protected AuctionItem auctionItem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AuctionPackage.Literals.BID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getPrice() {
		return price;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrice(long newPrice) {
		long oldPrice = price;
		price = newPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuctionPackage.BID__PRICE, oldPrice, price));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuctionPackage.BID__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserId(String newUserId) {
		String oldUserId = userId;
		userId = newUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuctionPackage.BID__USER_ID, oldUserId, userId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuctionItem getAuctionItem() {
		if (auctionItem != null && auctionItem.eIsProxy()) {
			InternalEObject oldAuctionItem = (InternalEObject)auctionItem;
			auctionItem = (AuctionItem)eResolveProxy(oldAuctionItem);
			if (auctionItem != oldAuctionItem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AuctionPackage.BID__AUCTION_ITEM, oldAuctionItem, auctionItem));
			}
		}
		return auctionItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuctionItem basicGetAuctionItem() {
		return auctionItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAuctionItem(AuctionItem newAuctionItem, NotificationChain msgs) {
		AuctionItem oldAuctionItem = auctionItem;
		auctionItem = newAuctionItem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AuctionPackage.BID__AUCTION_ITEM, oldAuctionItem, newAuctionItem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuctionItem(AuctionItem newAuctionItem) {
		if (newAuctionItem != auctionItem) {
			NotificationChain msgs = null;
			if (auctionItem != null)
				msgs = ((InternalEObject)auctionItem).eInverseRemove(this, AuctionPackage.AUCTION_ITEM__BIDS, AuctionItem.class, msgs);
			if (newAuctionItem != null)
				msgs = ((InternalEObject)newAuctionItem).eInverseAdd(this, AuctionPackage.AUCTION_ITEM__BIDS, AuctionItem.class, msgs);
			msgs = basicSetAuctionItem(newAuctionItem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuctionPackage.BID__AUCTION_ITEM, newAuctionItem, newAuctionItem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AuctionPackage.BID__AUCTION_ITEM:
				if (auctionItem != null)
					msgs = ((InternalEObject)auctionItem).eInverseRemove(this, AuctionPackage.AUCTION_ITEM__BIDS, AuctionItem.class, msgs);
				return basicSetAuctionItem((AuctionItem)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AuctionPackage.BID__AUCTION_ITEM:
				return basicSetAuctionItem(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AuctionPackage.BID__PRICE:
				return getPrice();
			case AuctionPackage.BID__DATE:
				return getDate();
			case AuctionPackage.BID__USER_ID:
				return getUserId();
			case AuctionPackage.BID__AUCTION_ITEM:
				if (resolve) return getAuctionItem();
				return basicGetAuctionItem();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AuctionPackage.BID__PRICE:
				setPrice((Long)newValue);
				return;
			case AuctionPackage.BID__DATE:
				setDate((Date)newValue);
				return;
			case AuctionPackage.BID__USER_ID:
				setUserId((String)newValue);
				return;
			case AuctionPackage.BID__AUCTION_ITEM:
				setAuctionItem((AuctionItem)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AuctionPackage.BID__PRICE:
				setPrice(PRICE_EDEFAULT);
				return;
			case AuctionPackage.BID__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case AuctionPackage.BID__USER_ID:
				setUserId(USER_ID_EDEFAULT);
				return;
			case AuctionPackage.BID__AUCTION_ITEM:
				setAuctionItem((AuctionItem)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AuctionPackage.BID__PRICE:
				return price != PRICE_EDEFAULT;
			case AuctionPackage.BID__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case AuctionPackage.BID__USER_ID:
				return USER_ID_EDEFAULT == null ? userId != null : !USER_ID_EDEFAULT.equals(userId);
			case AuctionPackage.BID__AUCTION_ITEM:
				return auctionItem != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (price: ");
		result.append(price);
		result.append(", date: ");
		result.append(date);
		result.append(", userId: ");
		result.append(userId);
		result.append(')');
		return result.toString();
	}

} //BidImpl
