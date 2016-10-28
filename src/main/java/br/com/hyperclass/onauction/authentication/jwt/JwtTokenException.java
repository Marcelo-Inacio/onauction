/*
 * @(#)JwtTokenException.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenException extends AuthenticationException {
	
	private static final long serialVersionUID = 1L;

    public JwtTokenException(final String message) {
        super(message);
    }

}
