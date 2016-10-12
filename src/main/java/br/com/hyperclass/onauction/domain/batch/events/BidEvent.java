/*
 * @(#)BidEvent.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch.events;

import java.util.EventObject;

public abstract class BidEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	
	public BidEvent(final ContextBidEvent event) {
		super(event);
	}
	
	public double getValue() {
		return getSource().getValue();
	}
	
	public BidTypeEvent getType() {
		return getSource().getType();
	}
	
	@Override
    public ContextBidEvent getSource() {
        return (ContextBidEvent) super.getSource();
    }

}
