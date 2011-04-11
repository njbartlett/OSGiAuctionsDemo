/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.auction.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.example.auction.AuctionFactory;
import org.example.auction.AuctionItem;
import org.example.auction.AuctionPackage;
import org.example.auction.Bid;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AuctionPackageImpl extends EPackageImpl implements AuctionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass auctionItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bidEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.example.auction.AuctionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AuctionPackageImpl() {
		super(eNS_URI, AuctionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link AuctionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AuctionPackage init() {
		if (isInited) return (AuctionPackage)EPackage.Registry.INSTANCE.getEPackage(AuctionPackage.eNS_URI);

		// Obtain or create and register package
		AuctionPackageImpl theAuctionPackage = (AuctionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AuctionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AuctionPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theAuctionPackage.createPackageContents();

		// Initialize created meta-data
		theAuctionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAuctionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AuctionPackage.eNS_URI, theAuctionPackage);
		return theAuctionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAuctionItem() {
		return auctionItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuctionItem_Description() {
		return (EAttribute)auctionItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAuctionItem_Bids() {
		return (EReference)auctionItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuctionItem_ExpiryDate() {
		return (EAttribute)auctionItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuctionItem_StartingPrice() {
		return (EAttribute)auctionItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBid() {
		return bidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBid_Price() {
		return (EAttribute)bidEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBid_Date() {
		return (EAttribute)bidEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBid_UserId() {
		return (EAttribute)bidEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBid_AuctionItem() {
		return (EReference)bidEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuctionFactory getAuctionFactory() {
		return (AuctionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		auctionItemEClass = createEClass(AUCTION_ITEM);
		createEAttribute(auctionItemEClass, AUCTION_ITEM__DESCRIPTION);
		createEReference(auctionItemEClass, AUCTION_ITEM__BIDS);
		createEAttribute(auctionItemEClass, AUCTION_ITEM__EXPIRY_DATE);
		createEAttribute(auctionItemEClass, AUCTION_ITEM__STARTING_PRICE);

		bidEClass = createEClass(BID);
		createEAttribute(bidEClass, BID__PRICE);
		createEAttribute(bidEClass, BID__DATE);
		createEAttribute(bidEClass, BID__USER_ID);
		createEReference(bidEClass, BID__AUCTION_ITEM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(auctionItemEClass, AuctionItem.class, "AuctionItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAuctionItem_Description(), ecorePackage.getEString(), "description", null, 0, 1, AuctionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAuctionItem_Bids(), this.getBid(), this.getBid_AuctionItem(), "bids", null, 0, -1, AuctionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuctionItem_ExpiryDate(), ecorePackage.getEDate(), "expiryDate", null, 0, 1, AuctionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuctionItem_StartingPrice(), ecorePackage.getELong(), "startingPrice", null, 0, 1, AuctionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bidEClass, Bid.class, "Bid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBid_Price(), ecorePackage.getELong(), "price", null, 0, 1, Bid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBid_Date(), ecorePackage.getEDate(), "date", null, 0, 1, Bid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBid_UserId(), ecorePackage.getEString(), "userId", null, 0, 1, Bid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBid_AuctionItem(), this.getAuctionItem(), this.getAuctionItem_Bids(), "auctionItem", null, 0, 1, Bid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AuctionPackageImpl
