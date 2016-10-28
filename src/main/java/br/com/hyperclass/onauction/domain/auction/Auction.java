/*
 * @(#)Auction.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.auction;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.domain.batch.BatchRepository;
import br.com.hyperclass.onauction.domain.batch.InvalidOperationBatchException;
import br.com.hyperclass.onauction.domain.batch.NoBatchIsOpenException;
import br.com.hyperclass.onauction.domain.batch.NotFoundBatchException;
import br.com.hyperclass.onauction.domain.user.Buyer;
import br.com.hyperclass.onauction.domain.user.User;
/**
 * A classe <code>Auction</code> contém as funcionalidades de toda apicacao.
 * @author Marcelo Inácio
 *
 */
public class Auction {
	
	private BatchRepository repository;
	private final Map<String, Buyer> buyers = new HashMap<>();
	private Batch currentBatch = null;
	
	public Auction(final List<User> buyers) {
		this.buyers.clear();
		loadBuyers(buyers);
	}
	
	public Batch createBatch(final Batch newBatch) {
		return repository.save(newBatch);
	}
	
	public void removeBatch(final int code) throws AuctionException {
		final Batch batch = repository.findById(code);
		if(batch == null) {
			throw new NotFoundBatchException();
		}
		if(!batch.isCreated()) {
			throw new InvalidOperationBatchException();			
		}
		repository.delete(code);
	}
	
	public Collection<Batch> getAllBatches() {
		return repository.findAll();
	}
	
	public Batch getCurrentBatch() throws AuctionException {
		if(currentBatch == null) {
			throw new NoBatchIsOpenException();
		}
		return currentBatch;
	}
	
	public void toBid(final String buyerCode, final double value) throws AuctionException {
		final Buyer buyer = (Buyer)buyers.get(buyerCode);
		if(currentBatch == null) {
			throw new NoBatchIsOpenException();
		}
		currentBatch.toBid(buyer, value);
	}
	
	public void closeBatch() throws AuctionException {
		if(currentBatch == null) {
			throw new NoBatchIsOpenException();
		}
		currentBatch.close();
		currentBatch = null;
	}
	
	public void openBatch(final int code) throws AuctionException {
		final Batch batch = repository.findById(code); 
		if(batch == null) {
			throw new NotFoundBatchException();
		}
		if(currentBatch != null) {
			throw new InvalidOperationBatchException();
		}
		currentBatch = batch;
		currentBatch.open();
	}
	
	public double getLastBidValue() throws AuctionException {
		if(currentBatch == null) {
			throw new NotFoundBatchException();
		}
		return currentBatch.getLastBidValue();
	}
	
	/**
	 * Método que recupera todos os lotes que ocorreram em uma determinada data.
	 * @param startDate
	 * @return
	 */
	public Collection<Batch> getAllBatchesByDate(final String date) {
		return repository.findByDate(date);
	}
	
	@Autowired
	public void setBatchRepository(final BatchRepository batchRepository) {
		this.repository = batchRepository;
	}
	
	/**
	 * Método responsável por preencher o mapa com a lista de usuário
	 * recebida do parâmetro
	 * @param buyers
	 */
	private void loadBuyers(final List<User> users) {
		for(final User user : users) {
			final Buyer buyer = (Buyer) user;
			this.buyers.put(buyer.getName(), buyer);
		}
	}
	
}
