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
/**
 * A classe <code>OnAuctionBeans</code> inst�ncia todos Beans necess�rios
 * de utiliza��o na aplica��o
 * @author Marcelo
 *
 */
@Configuration
public class OnAuctionBeans {
	/**
	 * Inst�ncia a classe princ�pal da aplica��o, que � utilizada na classe 
	 * <code>OnAuctionApplication</code> que cuida da seguran�a em n�vel de m�todo.
	 * @return
	 */
	@Bean
	public Auction auction() {
		return new Auction(buyersUsers());
	}
	/**
	 * Reposit�rio para acesso aos usu�rios da aplica��o.
	 * @return
	 */
	@Bean
	public UserRepository userRepository() {
		return new UserRepository(buyersUsers(), restrictUsers());
	}
	/**
	 * Usu�rios compradores cadastrados na aplica��o.
	 * @return
	 */
	@Bean
	public List<User> buyersUsers() {
		final List<User> buyers = new ArrayList<>();
		buyers.add(new Buyer("0010", "helio", new Login("helio","123")));
		buyers.add(new Buyer("0011", "sabrina", new Login("sabrina","123")));
		buyers.add(new Buyer("0012", "julia", new Login("julia","123")));
		buyers.add(new Buyer("0013", "ruy", new Login("ruy","123")));
		return buyers;
	}
	/**
	 * Usu�rios administradores e leiloerios cadastrados na aplica��o.
	 * @return
	 */
	@Bean
	public List<User> restrictUsers() {
		final List<User> users = new ArrayList<>();
		users.add(new Admin("admin", new Login("admin","admin")));
		users.add(new Auctioneer("auctioneer", new Login("auctioneer","auctioneer")));
		return users;
	}
	
}
