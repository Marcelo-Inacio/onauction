/*
 * @(#)ReferenceDateClaimsVerifier.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.hyperclass.onauction.domain.auction.Auction;
import br.com.hyperclass.onauction.domain.user.Admin;
import br.com.hyperclass.onauction.domain.user.Auctioneer;
import br.com.hyperclass.onauction.domain.user.Buyer;
import br.com.hyperclass.onauction.domain.user.Login;
import br.com.hyperclass.onauction.domain.user.User;
import br.com.hyperclass.onauction.domain.user.UserRepository;

@Configuration
public class OnAuctionBeans {

	@Bean
	public Auction auction() {
		return new Auction(buyersUsers());
	}
	
	@Bean
	public UserRepository userRepository() {
		return new UserRepository(buyersUsers(), restrictUsers());
	}
	
	@Bean
	public List<User> buyersUsers() {
		final List<User> buyers = new ArrayList<>();
		buyers.add(new Buyer("0010", "helio", new Login("helio","123")));
		buyers.add(new Buyer("0011", "sabrina", new Login("sabrina","123")));
		buyers.add(new Buyer("0012", "julia", new Login("julia","123")));
		buyers.add(new Buyer("0013", "ruy", new Login("ruy","123")));
		return buyers;
	}
	
	@Bean
	public List<User> restrictUsers() {
		final List<User> users = new ArrayList<>();
		users.add(new Admin("admin", new Login("admin","admin")));
		users.add(new Auctioneer("auctioneer", new Login("auctioneer","auctioneer")));
		return users;
	}
	
}
