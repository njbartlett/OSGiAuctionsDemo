/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.auction;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.example.auction.AuctionFactory
 * @model kind="package"
 * @generated
 */
public interface AuctionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "auction";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/example/auction.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.example.auction";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AuctionPackage eINSTANCE = org.example.auction.impl.AuctionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.example.auction.impl.AuctionItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.auction.impl.AuctionItemImpl
	 * @see org.example.auction.impl.AuctionPackageImpl#getAuctionItem()
	 * @generated
	 */
	int AUCTION_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUCTION_ITEM__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Bids</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUCTION_ITEM__BIDS = 1;

	/**
	 * The feature id for the '<em><b>Expiry Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUCTION_ITEM__EXPIRY_DATE = 2;

	/**
	 * The feature id for the '<em><b>Starting Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUCTION_ITEM__STARTING_PRICE = 3;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUCTION_ITEM_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.example.auction.impl.BidImpl <em>Bid</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.example.auction.impl.BidImpl
	 * @see org.example.auction.impl.AuctionPackageImpl#getBid()
	 * @generated
	 */
	int BID = 1;

	/**
	 * The feature id for the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BID__PRICE = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BID__DATE = 1;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BID__USER_ID = 2;

	/**
	 * The feature id for the '<em><b>Auction Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BID__AUCTION_ITEM = 3;

	/**
	 * The number of structural features of the '<em>Bid</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BID_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.example.auction.AuctionItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see org.example.auction.AuctionItem
	 * @generated
	 */
	EClass getAuctionItem();

	/**
	 * Returns the meta object for the attribute '{@link org.example.auction.AuctionItem#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.example.auction.AuctionItem#getDescription()
	 * @see #getAuctionItem()
	 * @generated
	 */
	EAttribute getAuctionItem_Description();

	/**
	 * Returns the meta object for the reference list '{@link org.example.auction.AuctionItem#getBids <em>Bids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bids</em>'.
	 * @see org.example.auction.AuctionItem#getBids()
	 * @see #getAuctionItem()
	 * @generated
	 */
	EReference getAuctionItem_Bids();

	/**
	 * Returns the meta object for the attribute '{@link org.example.auction.AuctionItem#getExpiryDate <em>Expiry Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiry Date</em>'.
	 * @see org.example.auction.AuctionItem#getExpiryDate()
	 * @see #getAuctionItem()
	 * @generated
	 */
	EAttribute getAuctionItem_ExpiryDate();

	/**
	 * Returns the meta object for the attribute '{@link org.example.auction.AuctionItem#getStartingPrice <em>Starting Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Starting Price</em>'.
	 * @see org.example.auction.AuctionItem#getStartingPrice()
	 * @see #getAuctionItem()
	 * @generated
	 */
	EAttribute getAuctionItem_StartingPrice();

	/**
	 * Returns the meta object for class '{@link org.example.auction.Bid <em>Bid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bid</em>'.
	 * @see org.example.auction.Bid
	 * @generated
	 */
	EClass getBid();

	/**
	 * Returns the meta object for the attribute '{@link org.example.auction.Bid#getPrice <em>Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Price</em>'.
	 * @see org.example.auction.Bid#getPrice()
	 * @see #getBid()
	 * @generated
	 */
	EAttribute getBid_Price();

	/**
	 * Returns the meta object for the attribute '{@link org.example.auction.Bid#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.example.auction.Bid#getDate()
	 * @see #getBid()
	 * @generated
	 */
	EAttribute getBid_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.example.auction.Bid#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see org.example.auction.Bid#getUserId()
	 * @see #getBid()
	 * @generated
	 */
	EAttribute getBid_UserId();

	/**
	 * Returns the meta object for the reference '{@link org.example.auction.Bid#getAuctionItem <em>Auction Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Auction Item</em>'.
	 * @see org.example.auction.Bid#getAuctionItem()
	 * @see #getBid()
	 * @generated
	 */
	EReference getBid_AuctionItem();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AuctionFactory getAuctionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.example.auction.impl.AuctionItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.auction.impl.AuctionItemImpl
		 * @see org.example.auction.impl.AuctionPackageImpl#getAuctionItem()
		 * @generated
		 */
		EClass AUCTION_ITEM = eINSTANCE.getAuctionItem();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUCTION_ITEM__DESCRIPTION = eINSTANCE.getAuctionItem_Description();

		/**
		 * The meta object literal for the '<em><b>Bids</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUCTION_ITEM__BIDS = eINSTANCE.getAuctionItem_Bids();

		/**
		 * The meta object literal for the '<em><b>Expiry Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUCTION_ITEM__EXPIRY_DATE = eINSTANCE.getAuctionItem_ExpiryDate();

		/**
		 * The meta object literal for the '<em><b>Starting Price</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUCTION_ITEM__STARTING_PRICE = eINSTANCE.getAuctionItem_StartingPrice();

		/**
		 * The meta object literal for the '{@link org.example.auction.impl.BidImpl <em>Bid</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.example.auction.impl.BidImpl
		 * @see org.example.auction.impl.AuctionPackageImpl#getBid()
		 * @generated
		 */
		EClass BID = eINSTANCE.getBid();

		/**
		 * The meta object literal for the '<em><b>Price</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BID__PRICE = eINSTANCE.getBid_Price();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BID__DATE = eINSTANCE.getBid_Date();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BID__USER_ID = eINSTANCE.getBid_UserId();

		/**
		 * The meta object literal for the '<em><b>Auction Item</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BID__AUCTION_ITEM = eINSTANCE.getBid_AuctionItem();

	}

} //AuctionPackage
