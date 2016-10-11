package br.com.hyperclass.onauction.user;

public class Buyer extends User {

	private static final long serialVersionUID = 1L;

	protected Buyer(final String name) {
		super(name, ProfileType.BUYER);
	}

}
