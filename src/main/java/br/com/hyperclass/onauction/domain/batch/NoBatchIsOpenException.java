package br.com.hyperclass.onauction.domain.batch;

import br.com.hyperclass.onauction.domain.auction.AuctionException;

public class NoBatchIsOpenException extends AuctionException {

	private static final long serialVersionUID = 1L;
	
	public NoBatchIsOpenException() {
		super();
	}

}
