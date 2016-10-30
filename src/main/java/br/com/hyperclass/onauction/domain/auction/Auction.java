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
import br.com.hyperclass.onauction.domain.batch.BatchNotFoundException;
import br.com.hyperclass.onauction.domain.user.Buyer;
import br.com.hyperclass.onauction.domain.user.User;
/**
 * A classe <code>Auction</code> cont�m as funcionalidades de toda apicacao.
 * @author Marcelo In�cio
 *
 */
public class Auction {
	
	private BatchRepository repository;
	private final Map<String, Buyer> buyers = new HashMap<>();
	private Batch currentBatch = null;
	/**
	 * Construtor necessita de um lista de compradores para utiliza��o de recursos da aplica��o 
	 * @param buyers
	 */
	public Auction(final List<User> buyers) {
		this.buyers.clear();
		loadBuyers(buyers);
	}
	/**
	 * Cria um novo lote para ser leiloado.
	 * @param newBatch
	 * @return
	 */
	public Batch createBatch(final Batch newBatch) {
		return repository.save(newBatch);
	}
	/**
	 * Exclui um lote cadastrado se o mesmo n�o existiver em andamento ou fechado.
	 * @param code
	 * @throws AuctionException
	 */
	public void removeBatch(final int code) throws AuctionException {
		final Batch batch = repository.findById(code);
		if(batch == null) {
			throw new BatchNotFoundException();
		}
		if(!batch.isCreated()) {
			throw new InvalidOperationBatchException("Removal");			
		}
		repository.delete(code);
	}
	/**
	 * Recupera todos os lotes cadastrados na aplica��o.
	 * @return
	 */
	public Collection<Batch> getAllBatches() {
		return repository.findAll();
	}
	/**
	 * Recupera o lote que est� em andamento no leil�o.
	 * @return
	 * @throws AuctionException
	 */
	public Batch getCurrentBatch() throws AuctionException {
		if(currentBatch == null) {
			throw new NoBatchIsOpenException();
		}
		return currentBatch;
	}
	/**
	 * M�todo que permite dar lance em um leil�o que esteje em andamento.
	 * @param buyerCode
	 * @param value
	 * @throws AuctionException
	 */
	public void toBid(final String buyerCode, final double value) throws AuctionException {
		final Buyer buyer = (Buyer)buyers.get(buyerCode);
		if(currentBatch == null) {
			throw new NoBatchIsOpenException();
		}
		currentBatch.toBid(buyer, value);
	}
	/**
	 * M�todo que realiza o encerramento de um lote em andamento no leil�o.
	 * @throws AuctionException
	 */
	public void closeBatch() throws AuctionException {
		if(currentBatch == null) {
			throw new NoBatchIsOpenException();
		}
		currentBatch.close();
		currentBatch = null;
	}
	/**
	 * M�todo que realiza a abetura de um lote para lances no leil�o
	 * @param code
	 * @throws AuctionException
	 */
	public void openBatch(final int code) throws AuctionException {
		final Batch batch = repository.findById(code); 
		if(batch == null) {
			throw new BatchNotFoundException();
		}
		if(currentBatch != null) {
			throw new InvalidOperationBatchException("Opening");
		}
		currentBatch = batch;
		currentBatch.open();
	}
	/**
	 * M�todo que recupera a �ltimo valor ofertado do lote que est� em andamento no leil�o.
	 * @return
	 * @throws AuctionException
	 */
	public double getLastBidValue() throws AuctionException {
		if(currentBatch == null) {
			throw new BatchNotFoundException();
		}
		return currentBatch.getLastBidValue();
	}
	
	/**
	 * M�todo que recupera todos os lotes que ocorreram em uma determinada data.
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
	 * M�todo respons�vel por preencher o mapa com a lista de usu�rio
	 * recebida do par�metro
	 * @param buyers
	 */
	private void loadBuyers(final List<User> users) {
		for(final User user : users) {
			final Buyer buyer = (Buyer) user;
			this.buyers.put(buyer.getName(), buyer);
		}
	}
	
}
