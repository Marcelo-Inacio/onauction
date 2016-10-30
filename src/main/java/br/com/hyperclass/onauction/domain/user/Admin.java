/*
 * @(#)Admin.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.user;
/**
 * A classe <code>Admin</code> representa um usuário administrador do leilão que pode
 * criar e excluir lotes.
 * 
 * @author Marcelo
 *
 */
public class Admin extends User {

	private static final long serialVersionUID = 1L;

	public Admin(final String name, final Login login) {
		super(name, login, ProfileType.ADMIN);
	}
	
}
