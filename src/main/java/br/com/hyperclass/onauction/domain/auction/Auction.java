/*
 * @(#)Auction.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.auction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.domain.batch.InvalidOperationBatchException;
import br.com.hyperclass.onauction.domain.batch.NotFoundBatchException;
import br.com.hyperclass.onauction.domain.batch.StatusBatch;

@Component
public class Auction {
	
	private final Map<Integer, Batch> batchMap = new HashMap<>();
	private Batch currentBatch = null;
	
	public void createBatch(final Batch newBatch) {
		batchMap.put(newBatch.getCode(), newBatch);
	}
	
	public void removeBatch(final int code) throws AuctionException {
		final Batch batch = batchMap.get(code);
		if(batch == null || !batch.getStatus().equals(StatusBatch.CREATED)) {
			throw new InvalidOperationBatchException();
		}
		batchMap.remove(code);
	}
	
	public Collection<Batch> getAllBatches() {
		return Collections.unmodifiableCollection(batchMap.values());
	}
	
	public Batch getCurrentBatch() throws AuctionException {
		if(currentBatch == null) {
			throw new NotFoundBatchException();
		}
		return currentBatch;
	}
	
	public void closeBatch() throws AuctionException {
		if(currentBatch == null) {
			throw new InvalidOperationBatchException();
		}
		currentBatch.close();
		currentBatch = null;
	}
	
	public void openBatch(final int code) throws AuctionException {
		final Batch batch = batchMap.get(code); 
		if(batch == null) {
			throw new NotFoundBatchException();
		}
		currentBatch = batch;
		currentBatch.open();
	}
	
	/**
	 * Método que recupera todos os lotes de uma determinada data
	 * @param date
	 * @return
	 */
	public Collection<Batch> getAllBatchesByDate(final Date date) {
		final List<Batch> allBatchesByDate = new ArrayList<>();
		
		return allBatchesByDate;
	}

}
