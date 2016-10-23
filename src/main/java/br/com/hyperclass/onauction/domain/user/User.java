/*
 * @(#)User.java 1.0 11/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.user;

import java.io.Serializable;

public abstract class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private final Login login;
	private final ProfileType profile;
	
	protected User(final String name, final Login login, final ProfileType profile) {
		this.name = name;
		this.login = login;
		this.profile = profile;
	}
	
	public String getName() {
		return name;
	}
	
	public ProfileType getProfile() {
		return profile;
	}

}
