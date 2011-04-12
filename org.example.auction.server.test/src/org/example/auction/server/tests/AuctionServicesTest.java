package org.example.auction.server.tests;

import junit.framework.TestCase;

import org.example.auction.AuctionFactory;
import org.example.auction.AuctionItem;
import org.example.auction.IAuctionService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class AuctionServicesTest extends TestCase {

    private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

    public void testAuctionService() throws Exception {
    	ServiceReference[] refs = context.getServiceReferences(IAuctionService.class.getName(), "(service.pid=auctions.EmfFile)");
    	assertTrue(refs != null && refs.length == 1);
    	
    	IAuctionService service = (IAuctionService) context.getService(refs[0]);
    	assertNotNull(service);
    	
    	try {
    		int beforeSize = service.listAuctionItems().size();
    		AuctionItem insertedItem = AuctionFactory.eINSTANCE.createAuctionItem();
			service.insertAuctionItem(insertedItem);
    		assertEquals(beforeSize + 1, service.listAuctionItems().size());
    	} finally {
    		context.ungetService(refs[0]);
    	}
    }
}
