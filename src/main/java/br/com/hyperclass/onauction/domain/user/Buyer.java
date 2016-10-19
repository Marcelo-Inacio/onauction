/*
 * @(#)Buyer.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.user;

public class Buyer extends User {

	private static final long serialVersionUID = 1L;
	
	private final String buyerCode;

	public Buyer(final String buyerCode, final String name, final Login login) {
		super(name, login, ProfileType.BUYER);
		this.buyerCode = buyerCode;
	}
	
	public String getCode() {
		return buyerCode;
	}
	
}
