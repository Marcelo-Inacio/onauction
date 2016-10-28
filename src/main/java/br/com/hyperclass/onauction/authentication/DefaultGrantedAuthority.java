/*
 * @(#)DefaultGrantedAuthority.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication;

import org.springframework.security.core.GrantedAuthority;

import br.com.hyperclass.onauction.domain.user.ProfileType;

public class DefaultGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	private final ProfileType role;
	
	public DefaultGrantedAuthority(final ProfileType role) {
        super();
        this.role = role;
    }

	/** {@inheritDoc} */
	@Override
	public String getAuthority() {
		return "ROLE_" + role.name();
	}
	
	public boolean isAdmin() {
        return role.isAdmin();
    }

}
