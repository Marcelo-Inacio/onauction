package br.com.hyperclass.onauction.auction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.hyperclass.onauction.user.Buyer;

public class Auction {
	
	private final Map<Integer, Batch> batchMap = new HashMap<>();
	private final Map<Bid, Buyer> bidsEvent = new LinkedHashMap<>();
	
	public Auction() {}
	
	public void createBatch(final Batch newBatch) {
		batchMap.put(newBatch.getCode(), newBatch);
	}
	
	public void removeBatch(final int code) {
		batchMap.remove(code);
	}
	
	public void newBid(final Bid bid, final Buyer buyer) {
		bidsEvent.put(bid, buyer);
	}
	
	public Batch getBatch(final int code) {
		return batchMap.get(code);
	}
	
	public void closeBatch(final int code) {
		batchMap.get(code).close();
	}
	
	public void openBatch(final int code) {
		batchMap.get(code).open();
	}

}
