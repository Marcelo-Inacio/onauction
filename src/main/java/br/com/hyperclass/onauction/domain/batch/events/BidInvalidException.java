/*
 * @(#)BidInvalidException.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch.events;

import br.com.hyperclass.onauction.domain.auction.AuctionException;
/**
 * A classe <code>BidInvalidException</code> representa e exceção de um lance inválido no leilão.
 * 
 * @author Marcelo
 *
 */
public class BidInvalidException extends AuctionException {

	private static final long serialVersionUID = 1L;
	
	private final double value;
	
	public BidInvalidException(final double value) {
		super();
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}

}
