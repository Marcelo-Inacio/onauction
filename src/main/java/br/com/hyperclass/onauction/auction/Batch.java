package br.com.hyperclass.onauction.auction;

public class Batch {
	
	private int code;
	private StatusBatch status;
	private final Product product;
	private final Bid minimumBid;
	private final double interval;
	
	public Batch(final int code, final Product product, final Bid minimumBid, final double interval) {
		this.code = code;
		this.status = StatusBatch.CEATED;
		this.product = product;
		this.minimumBid = minimumBid;
		this.interval = interval;
	}
	
	public void open() {
		this.status = StatusBatch.OPEN;
	}
	
	public void close() {
		this.status = StatusBatch.CLOSED;
	}
	
	public StatusBatch getStatus() {
		return status;
	}
	
	public int getCode() {
		return code;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public Bid getBid() {
		return minimumBid;
	}
	
	public double getInerval() {
		return interval;
	}

}
