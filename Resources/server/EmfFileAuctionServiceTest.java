package org.example.auction.server.emf;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.example.auction.AuctionItem;

import junit.framework.TestCase;

public class EmfFileAuctionServiceTest extends TestCase {
	public void testEmfAuctionService() {
		File dataDir = new File("testdata");
		
		Map<String,Object> config = new HashMap<String, Object>();
		config.put("baseDir", dataDir.getAbsolutePath());
		EmfFileAuctionService auctionService = new EmfFileAuctionService();
		auctionService.activate(config);
		
		Collection<AuctionItem> items = auctionService.listAuctionItems();
		assertEquals(3, items.size());
		
	}
}
