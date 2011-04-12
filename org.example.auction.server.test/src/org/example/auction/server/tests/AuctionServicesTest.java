package org.example.auction.server.tests;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.example.auction.AuctionFactory;
import org.example.auction.AuctionItem;
import org.example.auction.IAuctionService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class AuctionServicesTest extends TestCase {

    private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

    public void testAuctionService() throws Exception {
    	ServiceReference[] refs = context.getServiceReferences(IAuctionService.class.getName(), "(service.pid=auctions.EmfFile)");
    	assertTrue(refs != null && refs.length == 1);
    	
    	IAuctionService service = (IAuctionService) context.getService(refs[0]);
    	assertNotNull(service);
    	
    	final BlockingQueue<Event> events = new LinkedBlockingQueue<Event>();
    	EventHandler handler = new EventHandler() {
			public void handleEvent(Event event) {
				events.add(event);
			}
		};
		
		ServiceRegistration handlerReg = null;
    	try {
    		Properties handlerProps = new Properties();
    		handlerProps.setProperty("event.topics", "Auctions/Items/*");
			handlerReg = context.registerService(EventHandler.class.getName(), handler, handlerProps);
    		
    		int beforeSize = service.listAuctionItems().size();
    		AuctionItem insertedItem = AuctionFactory.eINSTANCE.createAuctionItem();
			service.insertAuctionItem(insertedItem);
    		assertEquals(beforeSize + 1, service.listAuctionItems().size());
    		
    		Event event = events.poll(2, TimeUnit.SECONDS);
    		assertNotNull(event);
    		assertEquals(EcoreUtil.getURI(insertedItem).toString(), event.getProperty("auctionItemId"));
    		
    	} finally {
    		context.ungetService(refs[0]);
    		if (handlerReg != null) handlerReg.unregister();
    	}
    }
}
