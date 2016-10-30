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
 * de quais os perfis podem acessam cada funcionalidade da aplicação.
 * 
 * @author Marcelo
 *
 */
@Component
public class OnAuctionApplication {
	
	private Auction auction;
	/**
	 * Se o usuario autenticado tiver permissão poderá criar um novo lote de produto.
	 * @param newBatch
	 * @return
	 */
	@PreAuthorize("principal.username == 'admin'")
	public Batch createBatch(final Batch newBatch) {
		return auction.createBatch(newBatch);
	}
	/**
	 * Se o usuario autenticado tiver permissão poderá excluir algum lote existente.
	 * @param code
	 * @throws AuctionException
	 */
	@PreAuthorize("principal.username == 'admin'")
	public void removeBatch(final int code) throws AuctionException {
		auction.removeBatch(code);
	}
	/**
	 * Se o usuario autenticado tiver permissão poderá recuperar todos lotes cadastrados.
	 * @return
	 */
	@PreAuthorize("principal.username == 'admin' or principal.username == 'auctioneer'")
	public Collection<Batch> getAllBatches() {
		return auction.getAllBatches();
	}
	/**
	 * Todos usuarios podem acessar este método autenticado ou não, que recupera o lote que está aberto
	 * para leilão.
	 * @return
	 * @throws AuctionException
	 */
	public Batch getCurrentBatch() throws AuctionException {
		return auction.getCurrentBatch();
	}
	/**
	 * Somente usuários compradores podem dar lances em lotes abertos no leilão.
	 * @param buyerCode
	 * @param value
	 * @throws AuctionException
	 */
	@PreAuthorize("principal.username != 'admin' and principal.username != 'auctioneer'")
	public void toBid(final String buyerCode, final double value) throws AuctionException {
		auction.toBid(buyerCode, value);
	}
	/**
	 * Somente usuários leiloeiros podem fechar lotes que estão em andamento no leilão.
	 * @throws AuctionException
	 */
	@PreAuthorize("principal.username == 'auctioneer'")
	public void closeBatch() throws AuctionException {
		auction.closeBatch();
	}
	/**
	 * Somente usuários leiloeiros podem iniciar lotes cadastrados para leilão.
	 * @param code
	 * @throws AuctionException
	 */
	@PreAuthorize("principal.username == 'auctioneer'")
	public void openBatch(final int code) throws AuctionException {
		auction.openBatch(code);
	}
	/**
	 * Somente administradores podem recuperar lotes que foram leiloados em uma
	 * determinada data. 
	 * @param date
	 * @return
	 */
	@PreAuthorize("principal.username == 'admin'")
	public Collection<Batch> getAllBatchesByDate(final String date) {
		return auction.getAllBatchesByDate(date);
	}
	/**
	 * Método que recupera o últimio lance do lote que está em leilão.
	 * @return
	 * @throws AuctionException
	 */
	public double getLastBidValue() throws AuctionException {
		return auction.getLastBidValue();
	}
	/**
	 * Injeção da dependencia da classe princípal por setter.
	 * @param auction
	 */
	@Autowired
	public void setAuction(final Auction auction) {
		this.auction = auction;
	}
}
