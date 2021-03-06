/*
 * @(#)Auctioneer.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.user;
/**
 * A classe <code>Auctioneer</code> representa um leiloeiro do leil�o que pode
 * iniciar e encerrar leil�es.
 * 
 * @author Marcelo
 *
 */
public class Auctioneer extends User {

	private static final long serialVersionUID = 1L;

	public Auctioneer(final String name, final Login login) {
		super(name, login, ProfileType.AUCTIONEER);
	}
	
}
