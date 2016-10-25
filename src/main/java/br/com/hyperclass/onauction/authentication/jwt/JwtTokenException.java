package br.com.hyperclass.onauction.authentication.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenException extends AuthenticationException {
	
	private static final long serialVersionUID = 1L;

    public JwtTokenException(final String message) {
        super(message);
    }

}
