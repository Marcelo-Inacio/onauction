/*
 * @(#)ReferenceDateClaimsVerifier.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.batch;

import br.com.hyperclass.onauction.domain.auction.AuctionException;

public class NoBatchIsOpenException extends AuctionException {

	private static final long serialVersionUID = 1L;
	
	public NoBatchIsOpenException() {
		super();
	}

}
