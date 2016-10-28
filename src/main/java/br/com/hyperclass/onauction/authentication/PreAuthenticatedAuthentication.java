/*
 * @(#)PreAuthenticatedAuthentication.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import br.com.hyperclass.onauction.domain.user.User;

public class PreAuthenticatedAuthentication extends PreAuthenticatedAuthenticationToken {
	
	private static final long serialVersionUID = 1L;

    public PreAuthenticatedAuthentication(final User user) {
        super(user, new DefaultGrantedAuthority(user.getProfile()));
        setAuthenticated(true);
    }

    @Override
    public User getPrincipal() {
        return (User) super.getPrincipal();
    }

    public boolean isAdmin() {
        final Collection<GrantedAuthority> authorities = getAuthorities();
        final Iterator<GrantedAuthority> it = authorities.iterator();
        while (it.hasNext()) {
            final DefaultGrantedAuthority auth = (DefaultGrantedAuthority) it.next();
            if (auth.isAdmin()) {
                return true;
            }
        }
        return false;
    }

}
