/*
 * @(#)CommonBidEvent.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch.events;
/**
 * A classe <code>ContextBidEvent</code> representa o contexto dos lances que ocorrem no leilão.
 * 
 * @author HyperClass04
 *
 */
public class ContextBidEvent {
	
	private final BidTypeEvent type;
	private final double value;
	
	
	public ContextBidEvent(final BidTypeEvent type, final double value) {
		this.type = type;
		this.value = value;
	}
	
	public BidTypeEvent getType() {
		return type;
	}
	
	public double getValue() {
		return value;
	}

}
