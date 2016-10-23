/*
 * @(#)Batch.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.com.hyperclass.onauction.domain.auction.AuctionException;
import br.com.hyperclass.onauction.domain.batch.events.BidEvent;
import br.com.hyperclass.onauction.domain.batch.events.BidInvalidException;
import br.com.hyperclass.onauction.domain.batch.events.CommonBidEvent;
import br.com.hyperclass.onauction.domain.batch.events.FinishBidEvent;
import br.com.hyperclass.onauction.domain.batch.events.InitialBidEvent;
import br.com.hyperclass.onauction.domain.user.Buyer;
/**
 * A classe <code>Batch</code> é uma entidade que representa o lote de produto 
 * a ser leiloado no leilao.
 * 
 * @author Marcelo
 *
 */
public class Batch implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int code;
	private StatusBatch status;
	private Product product;
	private final LinkedList<BidEvent> bidEvents = new LinkedList<>();
	private double valueInterval;
	private LocalDate date;
	
	public Batch(final Product product, final double InitialBid, final double valueInterval) {
		this.status = StatusBatch.CREATED;
		this.product = product;
		this.bidEvents.add(new InitialBidEvent(InitialBid));
		this.valueInterval = valueInterval;
	}
	
	public void toBid(final Buyer buyer, final double bidValue) throws AuctionException {
		final BidEvent lastBid = bidEvents.getLast();
		if((bidValue % valueInterval != 0) || bidValue < lastBid.getValue()) {
			throw new BidInvalidException(bidValue);
		}
		bidEvents.add(new CommonBidEvent(buyer, bidValue));
	}
	
	public void open() throws AuctionException {
		if(!status.equals(StatusBatch.CREATED)) {
			throw new InvalidOperationBatchException();
		}
		this.status = StatusBatch.OPEN;
		this.date = LocalDate.now();
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
	
	public double getValueInterval() {
		return valueInterval;
	}
	
	public String getDate() {
		final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return date.format(format);
	}
	
	public String getStatus() {
		return status.name();
	}
	
	public double getLastBidValue() {
		return bidEvents.getLast().getValue();
	}
	
	public double getInitialValue() {
		return bidEvents.getFirst().getValue();
	}
	
	public void setCode(final int code) {
		this.code = code;
	}

}
