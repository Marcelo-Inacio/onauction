/*
 * @(#)BadCredentialsExceptions.java 1.0 04/11/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.hyperclass.onauction.domain.auction.AuctionException;
/**
 * A classe <code>BadCredentialsExceptions</code> é chamada quando ocorre uma falha
 * ao tentar realizar login na aplicação, retornando um status http 401.
 * 
 * @author HyperClass04
 *
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BadCredentialsExceptions extends AuctionException {

	private static final long serialVersionUID = 1L;

	private final String message;
	
	public BadCredentialsExceptions(final String msg) {
		this.message = msg;
	}
	
	public String getMessage() {
		return message;
	}

}
