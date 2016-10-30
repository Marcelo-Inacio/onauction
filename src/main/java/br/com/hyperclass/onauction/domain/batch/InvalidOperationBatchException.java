/*
 * @(#)InvalidOperationBatchException.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch;

import br.com.hyperclass.onauction.domain.auction.AuctionException;
/**
 * A classe <code>InvalidOperationBatchException</code> representa a exceção,
 * que uma operação de mudança de estado não pode ser realizada no lote.
 * 
 * @author Marcelo
 *
 */
public class InvalidOperationBatchException extends AuctionException {

	private static final long serialVersionUID = 1L;
	
	private final String operation;
	
	public InvalidOperationBatchException(final String operation) {
		this.operation = operation;
	}
	
	public String getStatus() {
		return operation;
	}

}
