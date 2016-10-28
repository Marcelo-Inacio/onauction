/*
 * @(#)DefaultAuthenticationProvider.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.hyperclass.onauction.domain.user.User;
import br.com.hyperclass.onauction.domain.user.UserRepository;

@Component
public class DefaultAuthenticationProvider extends DaoAuthenticationProvider {
	
	private final UserRepository repository;
	
	@Autowired
    public DefaultAuthenticationProvider(final UserRepository repository, final UserDetailsService service, final PasswordEncoder encoder) {
        super();
        setUserDetailsService(service);
        setPasswordEncoder(encoder);
        this.repository = repository;
    }

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		final User user = repository.getByUsername(authentication.getName());
		return new PreAuthenticatedAuthentication(user);
	}

}
