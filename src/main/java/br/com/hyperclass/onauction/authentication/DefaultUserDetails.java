/*
 * @(#)DefaultUserDetails.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.hyperclass.onauction.domain.user.Login;
import br.com.hyperclass.onauction.domain.user.UserRepository;

@Component
public class DefaultUserDetails implements UserDetailsService {
	
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final br.com.hyperclass.onauction.domain.user.User user = repository.getByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User '" + username + "' not found.");
		}
		final Login login = user.getLogin();
		return new User(login.getUsername(), login.getUsername(), Collections.<GrantedAuthority> emptyList());
	}
	
	@Autowired
	public void setUserRepository(final UserRepository userRepository) {
		this.repository = userRepository;
	}

}
