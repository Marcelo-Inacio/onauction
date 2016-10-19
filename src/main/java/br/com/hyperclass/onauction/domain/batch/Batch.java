/*
 * @(#)Batch.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import br.com.hyperclass.onauction.domain.auction.AuctionException;
import br.com.hyperclass.onauction.domain.batch.events.BidEvent;
import br.com.hyperclass.onauction.domain.batch.events.BidInvalidException;
import br.com.hyperclass.onauction.domain.batch.events.CommonBidEvent;
import br.com.hyperclass.onauction.domain.batch.events.FinishBidEvent;
import br.com.hyperclass.onauction.domain.batch.events.InitialBidEvent;
import br.com.hyperclass.onauction.domain.user.Buyer;


public class Batch {
	
	private int code;
	private StatusBatch status;
	private final Product product;
	private final LinkedList<BidEvent> bidEvents = new LinkedList<>();
	private final double interval;
	private Date date;
	
	public Batch(final int code, final Product product, final double minimumValue, final double interval) {
		this.code = code;
		this.status = StatusBatch.CREATED;
		this.product = product;
		this.bidEvents.add(new InitialBidEvent(minimumValue));
		this.interval = interval;
	}
	
	public void toBid(final Buyer buyer, final double value) throws AuctionException {
		final BidEvent bid = bidEvents.getLast();
		if((bid.getValue() % value) != 0) {
			throw new BidInvalidException(value);
		}
		bidEvents.add(new CommonBidEvent(buyer, value));
	}
	
	public void open() throws AuctionException {
		if(!status.equals(StatusBatch.CREATED)) {
			throw new InvalidOperationBatchException();
		}
		this.status = StatusBatch.OPEN;
		this.date = new Date();
	}
	
	public void close() throws AuctionException {
		if(!status.equals(StatusBatch.OPEN)) {
			throw new InvalidOperationBatchException();
		}
		final CommonBidEvent lastBid = (CommonBidEvent) bidEvents.getLast();
		bidEvents.add(new FinishBidEvent(lastBid.getBuyer(), lastBid.getValue()));
		this.status = StatusBatch.CLOSED;
	}
	
	public boolean isCreated() {
		return status.equals(StatusBatch.CREATED);
	}
	
	public int getCode() {
		return code;
	}
	
	public String getProduct() {
		return product.getDescription();
	}
	
	public List<BidEvent> getBidEvents() {
		return Collections.unmodifiableList(bidEvents);
	}
	
	public double getInerval() {
		return interval;
	}
	
	public Date getDate() {
		return new Date(date.getTime());
	}
	
	public String getStatus() {
		return status.name();
	}

}
