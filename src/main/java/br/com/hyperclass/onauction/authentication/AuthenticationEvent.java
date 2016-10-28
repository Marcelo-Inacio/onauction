/*
 * @(#)AuthenticationEvent.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

import br.com.hyperclass.onauction.domain.user.User;

public class AuthenticationEvent extends AuthenticationSuccessEvent {

	private static final long serialVersionUID = 1L;
	private final HttpServletResponse response;
	
	public AuthenticationEvent(final HttpServletResponse response, final Authentication authentication) {
        super(authentication);
        this.response = response;
    }
	
	@Override
    public PreAuthenticatedAuthentication getAuthentication() {
        return (PreAuthenticatedAuthentication) super.getAuthentication();
    }

    public String getUsername() {
        return getUser().getName();
    }

    public HttpServletResponse getResponse() {
        return response;
    }
    
    public User getUserDomain() {
        return getAuthentication().getPrincipal();
    }

    private Principal getUser() {
        return getAuthentication().getPrincipal();
    }

}
