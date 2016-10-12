/*
 * @(#)Auctioneer.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.user;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.hyperclass.onauction.domain.auction.Auction;
import br.com.hyperclass.onauction.domain.auction.AuctionException;

public class Auctioneer extends User {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Auction auction;

	public Auctioneer(final String name) {
		super(name, ProfileType.AUCTIONNER);
	}
	
	public void openBatch(final int code) throws AuctionException {
		auction.openBatch(code);
	}
	
	public void closeBatch() throws AuctionException {
		auction.closeBatch();
	}
	
}
