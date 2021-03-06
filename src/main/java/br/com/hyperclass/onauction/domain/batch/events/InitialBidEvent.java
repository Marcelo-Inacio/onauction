/*
 * @(#)InitialBidEvent.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch.events;
/**
 * A classe <code>InitialBidEvent</code> representa o lance inicial do leil�o.
 * 
 * @author Marcelo
 *
 */
public class InitialBidEvent extends BidEvent {

	private static final long serialVersionUID = 1L;

	public InitialBidEvent(final double value) {
		super(new ContextBidEvent(BidTypeEvent.INITIAL, value));
	}

}
