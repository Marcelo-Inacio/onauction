/*
 * @(#)OnAuctionApplication.java 1.0 22/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.application;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import br.com.hyperclass.onauction.domain.auction.Auction;
import br.com.hyperclass.onauction.domain.auction.AuctionException;
import br.com.hyperclass.onauction.domain.batch.Batch;
/**
 * A classe <code>OnAuctionApplication</code> contém todas restrições de segurança em nível de método
 * de quais os perfis podem acessam cada funcionalidade.
 * 
 * @author Marcelo
 *
 */
@Component
public class OnAuctionApplication {
	
	private Auction auction;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Batch createBatch(final Batch newBatch) {
		return auction.createBatch(newBatch);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void removeBatch(final int code) throws AuctionException {
		auction.removeBatch(code);
	}
	
	@PreAuthorize("hasAnyRole({'ROLE_AUCTIONNER', 'ROLE_ADMIN', 'ROLE_ANONYMOUS'})")
	public Collection<Batch> getAllBatches() {
		return auction.getAllBatches();
	}
	
	
	public Batch getCurrentBatch() throws AuctionException {
		return auction.getCurrentBatch();
	}

	@PreAuthorize("hasRole('ROLE_BUYER')")
	public void toBid(final String buyerCode, final double value) throws AuctionException {
		auction.toBid(buyerCode, value);
	}
	
	@PreAuthorize("hasRole('ROLE_AUCTIONNER')")
	public void closeBatch() throws AuctionException {
		auction.closeBatch();
	}
	
	@PreAuthorize("hasRole('ROLE_AUCTIONNER')")
	public void openBatch(final int code) throws AuctionException {
		auction.openBatch(code);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Collection<Batch> getAllBatchesByDate(final String date) {
		return auction.getAllBatchesByDate(date);
	}
	
	public double getLastBidValue() throws AuctionException {
		return auction.getLastBidValue();
	}
	
	@Autowired
	public void setAuction(final Auction auction) {
		this.auction = auction;
	}
}
