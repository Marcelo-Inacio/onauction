/*
 * @(#)OnAuctionController.java 1.0 15/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hyperclass.onauction.domain.auction.Auction;
import br.com.hyperclass.onauction.domain.auction.AuctionException;
import br.com.hyperclass.onauction.domain.batch.Batch;
import br.com.hyperclass.onauction.domain.batch.Product;
import br.com.hyperclass.onauction.restapi.wrapper.BatchWrapper;
/**
 * A classe <code>OnAuctionController</code> contem as rotas de acesso as funcionalidades 
 * da aplicacao.
 *  
 * @author Marcelo
 *
 */
@RestController
@PreAuthorize("isAuthenticated()")
public class OnAuctionController {
	
	@Autowired
	private Auction auction;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/batch", method = RequestMethod.POST)
	public ResponseEntity<?> createBatch(@RequestBody final BatchWrapper batchWrapper) {
		auction.createBatch(new Batch(batchWrapper.getCode(), 
				new Product(batchWrapper.getProduct()),
				batchWrapper.getminimumValue(),
				batchWrapper.getInterval()));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/batch/{batchCode}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeBatch(final int batchCode) throws AuctionException {
		auction.removeBatch(batchCode);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_AUCTIONEER')")
	@RequestMapping(value = "/batch/{batchCode}/open", method = RequestMethod.POST)
	public ResponseEntity<?> openBatch(@PathVariable("batchCode") final int batchCode) throws AuctionException {
		auction.openBatch(batchCode);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_AUCTIONEER')")
	@RequestMapping(value = "/batch/close", method = RequestMethod.POST)
	public ResponseEntity<?> closeBatch() throws AuctionException {
		auction.closeBatch();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_BUYER')")
	@RequestMapping(value = "/{buyerCode}/toBid", method = RequestMethod.POST)
	public ResponseEntity<?> toBid(@PathVariable("buyerCode") final String buyerCode,
			@RequestParam("bidValue") final double bidValue) throws AuctionException {
		auction.toBid(buyerCode, bidValue);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
