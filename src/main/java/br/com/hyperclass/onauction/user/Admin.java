package br.com.hyperclass.onauction.user;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.hyperclass.onauction.auction.Auction;
import br.com.hyperclass.onauction.auction.Batch;

public class Admin extends User {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Auction auction;

	protected Admin(final String name) {
		super(name, ProfileType.ADMIN);
	}

	public void createBatch(final Batch newBatch) {
		auction.createBatch(newBatch);
	}
	
	public void removeBatch(final int batchCode) {
		auction.removeBatch(batchCode);
	}
	
}
