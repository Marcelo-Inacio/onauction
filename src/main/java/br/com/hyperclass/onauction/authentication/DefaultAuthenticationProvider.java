/*
 * @(#)DefaultAuthenticationProvider.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import br.com.hyperclass.onauction.domain.auction.AuctionException;
import br.com.hyperclass.onauction.domain.user.User;
import br.com.hyperclass.onauction.domain.user.UserRepository;

@Component
public class DefaultAuthenticationProvider implements AuthenticationProvider {
	
	private UserRepository repository;

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		User user = null;
		try {
			user = repository.getByUsername(authentication.getName());
			if(!user.getPassword().equals(authentication.getCredentials())) {
				throw new BadCredentialsExceptions("username/password invalid");
			}
		} catch (final AuctionException e) {
			e.printStackTrace();
		}
		return new PreAuthenticatedAuthentication(user);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
	
	@Autowired
	public void setRepository(final UserRepository userRepository) {
		repository = userRepository;
	}

}
