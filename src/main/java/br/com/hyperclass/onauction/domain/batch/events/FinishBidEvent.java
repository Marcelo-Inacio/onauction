/*
 * @(#)FinishBidEvent.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch.events;

import br.com.hyperclass.onauction.domain.user.Buyer;
/**
 * A classe <code>FinishBidEvent</code> representa o último lance ofertado antes
 * do encerramento do leilão.
 * 
 * @author Marcelo
 *
 */
public class FinishBidEvent extends BidEvent {

	private static final long serialVersionUID = 1L;
	
	private final Buyer buyer;

	public FinishBidEvent(final Buyer buyer, final double value) {
		super(new ContextBidEvent(BidTypeEvent.FINISH, value));
		this.buyer = buyer;
	}
	
	public Buyer getBuyer() {
		return buyer;
	}

}
