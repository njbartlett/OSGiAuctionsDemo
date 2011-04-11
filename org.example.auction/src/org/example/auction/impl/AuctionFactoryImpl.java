/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.auction.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.example.auction.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AuctionFactoryImpl extends EFactoryImpl implements AuctionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AuctionFactory init() {
		try {
			AuctionFactory theAuctionFactory = (AuctionFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/example/auction.ecore"); 
			if (theAuctionFactory != null) {
				return theAuctionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AuctionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuctionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AuctionPackage.AUCTION_ITEM: return createAuctionItem();
			case AuctionPackage.BID: return createBid();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuctionItem createAuctionItem() {
		AuctionItemImpl auctionItem = new AuctionItemImpl();
		return auctionItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bid createBid() {
		BidImpl bid = new BidImpl();
		return bid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuctionPackage getAuctionPackage() {
		return (AuctionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AuctionPackage getPackage() {
		return AuctionPackage.eINSTANCE;
	}

} //AuctionFactoryImpl
