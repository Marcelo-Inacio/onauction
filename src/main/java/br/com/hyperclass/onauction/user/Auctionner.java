package br.com.hyperclass.onauction.user;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.hyperclass.onauction.auction.Auction;

public class Auctionner extends User {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Auction auction;

	protected Auctionner(final String name) {
		super(name, ProfileType.AUCTIONNER);
	}
	
	public void openBatch(final int code) {
		auction.openBatch(code);
	}
	
	public void closeBatch(final int code) {
		auction.closeBatch(code);
	}
	
}
