/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.auction.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.example.auction.AuctionItem;
import org.example.auction.AuctionPackage;
import org.example.auction.Bid;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.auction.impl.AuctionItemImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.example.auction.impl.AuctionItemImpl#getBids <em>Bids</em>}</li>
 *   <li>{@link org.example.auction.impl.AuctionItemImpl#getExpiryDate <em>Expiry Date</em>}</li>
 *   <li>{@link org.example.auction.impl.AuctionItemImpl#getStartingPrice <em>Starting Price</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AuctionItemImpl extends EObjectImpl implements AuctionItem {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBids() <em>Bids</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBids()
	 * @generated
	 * @ordered
	 */
	protected EList<Bid> bids;

	/**
	 * The default value of the '{@link #getExpiryDate() <em>Expiry Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpiryDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date EXPIRY_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpiryDate() <em>Expiry Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpiryDate()
	 * @generated
	 * @ordered
	 */
	protected Date expiryDate = EXPIRY_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartingPrice() <em>Starting Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingPrice()
	 * @generated
	 * @ordered
	 */
	protected static final long STARTING_PRICE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStartingPrice() <em>Starting Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingPrice()
	 * @generated
	 * @ordered
	 */
	protected long startingPrice = STARTING_PRICE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuctionItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AuctionPackage.Literals.AUCTION_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuctionPackage.AUCTION_ITEM__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Bid> getBids() {
		if (bids == null) {
			bids = new EObjectWithInverseResolvingEList<Bid>(Bid.class, this, AuctionPackage.AUCTION_ITEM__BIDS, AuctionPackage.BID__AUCTION_ITEM);
		}
		return bids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpiryDate(Date newExpiryDate) {
		Date oldExpiryDate = expiryDate;
		expiryDate = newExpiryDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuctionPackage.AUCTION_ITEM__EXPIRY_DATE, oldExpiryDate, expiryDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStartingPrice() {
		return startingPrice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartingPrice(long newStartingPrice) {
		long oldStartingPrice = startingPrice;
		startingPrice = newStartingPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuctionPackage.AUCTION_ITEM__STARTING_PRICE, oldStartingPrice, startingPrice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AuctionPackage.AUCTION_ITEM__BIDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBids()).basicAdd(otherEnd, msgs);
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
			case AuctionPackage.AUCTION_ITEM__BIDS:
				return ((InternalEList<?>)getBids()).basicRemove(otherEnd, msgs);
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
			case AuctionPackage.AUCTION_ITEM__DESCRIPTION:
				return getDescription();
			case AuctionPackage.AUCTION_ITEM__BIDS:
				return getBids();
			case AuctionPackage.AUCTION_ITEM__EXPIRY_DATE:
				return getExpiryDate();
			case AuctionPackage.AUCTION_ITEM__STARTING_PRICE:
				return getStartingPrice();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AuctionPackage.AUCTION_ITEM__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case AuctionPackage.AUCTION_ITEM__BIDS:
				getBids().clear();
				getBids().addAll((Collection<? extends Bid>)newValue);
				return;
			case AuctionPackage.AUCTION_ITEM__EXPIRY_DATE:
				setExpiryDate((Date)newValue);
				return;
			case AuctionPackage.AUCTION_ITEM__STARTING_PRICE:
				setStartingPrice((Long)newValue);
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
			case AuctionPackage.AUCTION_ITEM__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case AuctionPackage.AUCTION_ITEM__BIDS:
				getBids().clear();
				return;
			case AuctionPackage.AUCTION_ITEM__EXPIRY_DATE:
				setExpiryDate(EXPIRY_DATE_EDEFAULT);
				return;
			case AuctionPackage.AUCTION_ITEM__STARTING_PRICE:
				setStartingPrice(STARTING_PRICE_EDEFAULT);
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
			case AuctionPackage.AUCTION_ITEM__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case AuctionPackage.AUCTION_ITEM__BIDS:
				return bids != null && !bids.isEmpty();
			case AuctionPackage.AUCTION_ITEM__EXPIRY_DATE:
				return EXPIRY_DATE_EDEFAULT == null ? expiryDate != null : !EXPIRY_DATE_EDEFAULT.equals(expiryDate);
			case AuctionPackage.AUCTION_ITEM__STARTING_PRICE:
				return startingPrice != STARTING_PRICE_EDEFAULT;
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
		result.append(" (description: ");
		result.append(description);
		result.append(", expiryDate: ");
		result.append(expiryDate);
		result.append(", startingPrice: ");
		result.append(startingPrice);
		result.append(')');
		return result.toString();
	}

} //AuctionItemImpl
