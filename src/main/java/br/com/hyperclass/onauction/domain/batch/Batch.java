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
import br.com.hyperclass.onauction.domain.batch.events.BidTypeEvent;
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
	private LocalDate date = null;
	
	public Batch(final Product product, final double InitialBid, final double valueInterval) {
		this.status = StatusBatch.CREATED;
		this.product = product;
		this.bidEvents.add(new InitialBidEvent(InitialBid));
		this.valueInterval = valueInterval;
	}
	/**
	 * Método que cria um evento de um lance ofertado no lote se o valor for maior que
	 * o ultimo lance e se multiplo do valor de intervalo.
	 * @param buyer
	 * @param bidValue
	 * @throws AuctionException
	 */
	public void toBid(final Buyer buyer, final double bidValue) throws AuctionException {
		final BidEvent lastBid = bidEvents.getLast();
		if((bidValue % valueInterval != 0) || bidValue < lastBid.getValue()) {
			throw new BidInvalidException(bidValue);
		}
		bidEvents.add(new CommonBidEvent(buyer, bidValue));
	}
	/**
	 * Método que realiza a mudança de estado do lote para aberto,
	 * se o mesmo não estiver em andamento
	 * ou fechado.
	 * @throws AuctionException
	 */
	public void open() throws AuctionException {
		if(!status.equals(StatusBatch.CREATED)) {
			throw new InvalidOperationBatchException("Opening");
		}
		this.status = StatusBatch.OPEN;
		this.date = LocalDate.now();
	}
	/**
	 * Método que realiza a mudança de estado do lote para fechado,
	 * se não estiver com estado em modo criado ou fechado.
	 * @throws AuctionException
	 */
	public void close() throws AuctionException {
		if(!status.equals(StatusBatch.OPEN)) {
			throw new InvalidOperationBatchException("Closing");
		}
		this.status = StatusBatch.CLOSED;
		final BidEvent lastBidEvent = bidEvents.getLast();
		if(lastBidEvent.getType() != BidTypeEvent.INITIAL) {
			final CommonBidEvent lastCommonBidEvent = (CommonBidEvent) lastBidEvent;
			bidEvents.add(new FinishBidEvent(lastCommonBidEvent.getBuyer(), lastCommonBidEvent.getValue()));
		} else {
			bidEvents.add(new FinishBidEvent(null, lastBidEvent.getValue()));			
		}
	}
	/**
	 * Método que verifica se o estado do lote está criado
	 * @return
	 */
	public boolean isCreated() {
		return status.equals(StatusBatch.CREATED);
	}
	
	public int getCode() {
		return code;
	}
	
	public String getProduct() {
		return product.getDescription();
	}
	/**
	 * Método que recupera todos os eventos que aconteceram no lote.
	 * @return
	 */
	public List<BidEvent> getBidEvents() {
		return Collections.unmodifiableList(bidEvents);
	}
	
	public double getValueInterval() {
		return valueInterval;
	}
	/**
	 * Método que recupra a data em que o lote foi leiloado já formata. 
	 * @return
	 */
	public String getDate() {
		if(date == null) {
			return "";
		}
		final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return date.format(format);
	}
	
	public String getStatus() {
		return status.name();
	}
	/**
	 * Método que recupera o último valor ofertado no lote.
	 * @return
	 */
	public double getLastBidValue() {
		return bidEvents.getLast().getValue();
	}
	/**
	 * Método que recupera o valor de lance inicial do lote.
	 * @return
	 */
	public double getInitialValue() {
		return bidEvents.getFirst().getValue();
	}
	/**
	 * Método seta o código do lote quando repositório o cria.
	 * @param code
	 */
	public void setCode(final int code) {
		this.code = code;
	}

}
