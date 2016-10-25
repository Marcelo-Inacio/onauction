/*
 * @(#)OnAuctionController.java 1.0 15/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hyperclass.onauction.application.OnAuctionApplication;
import br.com.hyperclass.onauction.domain.auction.AuctionException;
import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.restapi.wrapper.AbstractBatchListWrapper;
import br.com.hyperclass.onauction.restapi.wrapper.BatchWrapper;
import br.com.hyperclass.onauction.restapi.wrapper.BatchHistoricListWrapper;
import br.com.hyperclass.onauction.restapi.wrapper.BatchListWrapper;
import br.com.hyperclass.onauction.restapi.wrapper.BidWrapper;
import br.com.hyperclass.onauction.restapi.wrapper.DateWrapper;
/**
 * A classe <code>OnAuctionController</code> contem as rotas de acesso as funcionalidades 
 * da aplicacao.
 *  
 * @author Marcelo
 *
 */
@RestController
public class OnAuctionController {
	
	private HttpHeadersBuilder headersBuilder;
	private OnAuctionApplication auction;
	
	/**
	 * URI responsavel por cadastrar um novo lote de produto no leilao.
	 * @param batchWrapper
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/batch", method = RequestMethod.POST)
	public ResponseEntity<BatchWrapper> createBatch(@RequestBody final BatchWrapper batchWrapper, 
			final HttpServletRequest request) {
		
		final Batch batch = auction.createBatch(batchWrapper.getBatch());
		final BatchWrapper batchWrapperResponse = new BatchWrapper(batch);
		return new ResponseEntity<>(batchWrapperResponse, getHeaders(batch), HttpStatus.CREATED);
	}
	
	/**
	 * URI responsavel por excluir um lote de produto do leilao.
	 * @param batchCode
	 * @return
	 * @throws AuctionException
	 */
	@RequestMapping(value = "/batch/{batchCode}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeBatch(@PathVariable("batchCode") final Integer batchCode) throws AuctionException {
		auction.removeBatch(batchCode);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * URI responsavel por retornar todos lotes disponiveis no leilao
	 * @return
	 */
	@RequestMapping(value = "/batches", method = RequestMethod.GET)
	public ResponseEntity<AbstractBatchListWrapper> getAllBatches() {
		final AbstractBatchListWrapper list = new BatchListWrapper(auction.getAllBatches());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	/**
	 * URI responsavel por iniciar lotes do leilao.
	 * @param batchCode
	 * @return
	 * @throws AuctionException
	 */
	@RequestMapping(value = "/batch/{batchCode}/open", method = RequestMethod.POST)
	public ResponseEntity<?> openBatch(@PathVariable("batchCode") final Integer batchCode) throws AuctionException {
		auction.openBatch(batchCode);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * URI responsavel por fechar lote que esta aberto no leilao.
	 * @return
	 * @throws AuctionException
	 */
	@RequestMapping(value = "/batch/close", method = RequestMethod.POST)
	public ResponseEntity<?> closeBatch() throws AuctionException {
		auction.closeBatch();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * URI responsavel por dar lances no lote de produto em aberto.
	 * @param buyerCode
	 * @param bidValue
	 * @return
	 * @throws AuctionException
	 */
	@RequestMapping(value = "/{buyerCode}/toBid", method = RequestMethod.POST)
	public ResponseEntity<?> toBid(@PathVariable("buyerCode") final String buyerCode,
			@RequestBody final BidWrapper bidValue) throws AuctionException {
		auction.toBid(buyerCode, bidValue.getValue());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * URI responsavel por recuperar ultimo valor de lance dado no lote de produto
	 * que esta em andamento.
	 * @return
	 * @throws AuctionException
	 */
	@RequestMapping(value = "/lastBid", method = RequestMethod.GET)
	public ResponseEntity<BidWrapper> getLastBid() throws AuctionException {
		final Batch batch = auction.getCurrentBatch();
		return new ResponseEntity<>(new BidWrapper(auction.getLastBidValue(), batch.getProduct(), batch.getValueInterval()), HttpStatus.OK);
	}
	
	/**
	 * URI responsavel por recuperar todos os lotes de produto que ocorreram em um determinada data 
	 * @param date
	 * @return
	 */
	@RequestMapping(value = "/batches/date", method = RequestMethod.POST)
	public ResponseEntity<AbstractBatchListWrapper> getBatchesByDate(@RequestBody final DateWrapper date) {
		final AbstractBatchListWrapper batchWrapperList = new BatchHistoricListWrapper(auction.getAllBatchesByDate(date.getDateFormatPtBr()));
		return new ResponseEntity<>(batchWrapperList, HttpStatus.OK);
	}
	
	@Autowired
	public void setOnAuctionApplication(final OnAuctionApplication onAuctionApplication) {
		this.auction = onAuctionApplication;
	}
	
	@Autowired
	public void setBuilder(final HttpHeadersBuilder headersBuilder) {
		this.headersBuilder = headersBuilder;
	}
	
	/**
	 * Método responsavel por retornar o location do recurso
	 * @param batch
	 * @return
	 */
	private HttpHeaders getHeaders(final Batch batch) {
		return headersBuilder.batchId(batch.getCode()).build();
	}

}
