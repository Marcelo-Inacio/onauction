/*
 * @(#)User.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.user;
/**
 * A classe abstrata <code>User</code> representa um usário qualquer que acessa o leilão.
 * 
 * @author Marcelo
 * 
 */
import java.io.Serializable;
import java.security.Principal;

public abstract class User implements Principal, Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private final Login login;
	private final ProfileType profile;
	
	protected User(final String name, final Login login, final ProfileType profile) {
		this.name = name;
		this.login = login;
		this.profile = profile;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public ProfileType getProfile() {
		return profile;
	}
	
	public Login getLogin() {
		return login;
	}
	
	public String getUsername() {
		return login.getUsername();
	}

	public String getPassword() {
		return login.getPassword();
	}

}
