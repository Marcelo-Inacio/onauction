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
 * A classe <code>Auction</code> contém as funcionalidades de toda apicacao.
 * @author Marcelo Inácio
 *
 */
public class Auction {
	
	private BatchRepository repository;
	private final Map<String, Buyer> buyers = new HashMap<>();
	private Batch currentBatch = null;
	/**
	 * Construtor necessita de um lista de compradores para utilização de recursos da aplicação 
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
	 * Exclui um lote cadastrado se o mesmo não existiver em andamento ou fechado.
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
	 * Recupera todos os lotes cadastrados na aplicação.
	 * @return
	 */
	public Collection<Batch> getAllBatches() {
		return repository.findAll();
	}
	/**
	 * Recupera o lote que está em andamento no leilão.
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
	 * Método que permite dar lance em um leilão que esteje em andamento.
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
	 * Método que realiza o encerramento de um lote em andamento no leilão.
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
	 * Método que realiza a abetura de um lote para lances no leilão
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
	 * Método que recupera a último valor ofertado do lote que está em andamento no leilão.
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
