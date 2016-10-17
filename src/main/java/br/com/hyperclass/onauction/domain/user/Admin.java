/*
 * @(#)Admin.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.user;

import br.com.hyperclass.onauction.domain.auction.AuctionException;
import br.com.hyperclass.onauction.domain.batch.Batch;

public class Admin extends User {

	private static final long serialVersionUID = 1L;

	public Admin(final String name, final Login login) {
		super(name, login, ProfileType.ADMIN);
	}

	public void createBatch(final Batch newBatch) {
		super.auction.createBatch(newBatch);
	}
	
	public void removeBatch(final int batchCode) throws AuctionException {
		super.auction.removeBatch(batchCode);
	}
	
}
