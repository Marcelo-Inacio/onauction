/*
 * @(#)DefaultUserDetails.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import br.com.hyperclass.onauction.domain.auction.AuctionException;
import br.com.hyperclass.onauction.domain.user.Login;
import br.com.hyperclass.onauction.domain.user.UserRepository;

@Component
public class DefaultUserDetails implements UserDetailsService {
	
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(final String username) {
		br.com.hyperclass.onauction.domain.user.User user = null;
		try {
			user = repository.getByUsername(username);
		} catch(final AuctionException e) {
			e.printStackTrace();
		}
		final Login login = user.getLogin();
		return new User(login.getUsername(), login.getUsername(), getRoles(user));
	}
	
	private Collection<GrantedAuthority> getRoles(final br.com.hyperclass.onauction.domain.user.User user) {
		final List<GrantedAuthority> authorities = new ArrayList<>(1);
		authorities.add(new DefaultGrantedAuthority(user.getProfile()));
		return authorities;
	}
	
	@Autowired
	public void setUserRepository(final UserRepository userRepository) {
		this.repository = userRepository;
	}

}
