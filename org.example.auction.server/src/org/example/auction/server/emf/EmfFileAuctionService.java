package org.example.auction.server.emf;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.example.auction.AuctionItem;
import org.example.auction.AuctionPackage;
import org.example.auction.Bid;
import org.example.auction.IAuctionService;
import org.osgi.framework.Constants;
import org.osgi.service.log.LogService;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.ConfigurationPolicy;
import aQute.bnd.annotation.component.Reference;
import aQute.bnd.annotation.metatype.Configurable;
import aQute.bnd.annotation.metatype.Meta;

@Component(properties = { "service.pid=" + EmfFileAuctionService.SERVICE_PID, "label=" + EmfFileAuctionService.DEFAULT_LABEL },
		designate = EmfFileAuctionService.Config.class,
		configurationPolicy = ConfigurationPolicy.optional)
public class EmfFileAuctionService implements IAuctionService {
	
	static final String SERVICE_PID = "auctions.EmfFile";
	static final String DEFAULT_LABEL = "EMF File Based";
	
	public interface Config {
		@Meta.AD(id = "label", deflt = DEFAULT_LABEL, required = true)
		String label();
		
		@Meta.AD(id = "baseDir", deflt = ".", required = false)
		String baseDir();
		
		@Meta.AD(id = "auctionItemFileName", deflt = "items.xml", required = false)
		String auctionItemFileName();
		
		@Meta.AD(id = "bidFileName", deflt = "bids.xml", required = false)
		String bidFileName();
	}
	
	private final ResourceSet resourceSet = new ResourceSetImpl();
	private final AtomicReference<LogService> logSvcRef = new AtomicReference<LogService>();
	private Resource auctionItemsResource;
	private Resource bidsResource;
	private String pid;
	private Config config;
	
	public EmfFileAuctionService() {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(AuctionPackage.eNS_URI, AuctionPackage.eINSTANCE);
	}
	
	@Activate
	public void activate(Map<String, Object> configProps) {
		pid = (String) configProps.get(Constants.SERVICE_PID);
		if (pid == null) pid = SERVICE_PID;
		
		config = Configurable.createConfigurable(Config.class, configProps);
		
		File baseDir = new File(config.baseDir());
		if (!baseDir.isDirectory())
			throw new IllegalArgumentException("Base directory does not exist: " + baseDir.getAbsolutePath());
		
		File auctionsFile = new File(baseDir, config.auctionItemFileName());
		auctionItemsResource = createOrGetResource(auctionsFile);
		
		File bidsFile = new File(baseDir, config.bidFileName());
		bidsResource = createOrGetResource(bidsFile);
		
		auctionItemsResource.eAdapters().add(new EContentAdapter() {
			@Override
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				
				switch (msg.getEventType()) {
				case org.eclipse.emf.common.notify.Notification.ADD:
				case org.eclipse.emf.common.notify.Notification.ADD_MANY:
					handleAdd(msg.getNewValue());
				}
			}
			void handleAdd(Object obj) {
				if (obj instanceof Collection<?>) {
					for (Object item : (Collection<?>) obj) {
						handleAdd(item);
					}
				} else if (obj instanceof AuctionItem) {
					fireItemAdded((AuctionItem) obj);
				} else if (obj instanceof Bid) {
					fireBidAdded((Bid) obj);
				}
			}
		});
	}
	
	Resource createOrGetResource(File file) {
		URI uri = URI.createFileURI(file.getAbsolutePath());
		return file.exists() ? resourceSet.getResource(uri, true) : resourceSet.createResource(uri);
	}

	void fireItemAdded(AuctionItem item) {
		saveResource(auctionItemsResource);
	}

	void fireBidAdded(Bid bid) {
		bidsResource.getContents().add(bid);
	
		saveResource(auctionItemsResource);
		saveResource(bidsResource);
	}
	
	void saveResource(Resource resource) {
		try {
			resource.save(null);
		} catch (IOException e) {
			LogService log = logSvcRef.get();
			if (log != null)
				log.log(LogService.LOG_ERROR, "Error saving EMF resource: " + resource.getURI().toString(), e);
		}
	}
	
	@Override
	public String insertAuctionItem(AuctionItem item) throws IOException {
		auctionItemsResource.getContents().add(item);
		URI uri = EcoreUtil.getURI(item);
		return uri.toString();
	}

	@Override
	public AuctionItem findItem(String id) {
		EObject object = resourceSet.getEObject(URI.createURI(id), true);
		if (object instanceof AuctionItem)
			return (AuctionItem) object;
		throw new IllegalArgumentException("Invalid ID for Auction Item: " + id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection<AuctionItem> listAuctionItems() {
		EList contents = auctionItemsResource.getContents();
		return contents;
	}
	
	@Reference(type = '?')
	protected void bindLog(LogService log) {
		logSvcRef.set(log);
	}
	
	protected void unbindLog(LogService log) {
		logSvcRef.compareAndSet(log, null);
	}

}
