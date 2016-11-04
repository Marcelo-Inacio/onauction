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
 * A classe <code>OnAuctionBeans</code> instância todos Beans necessários
 * de utilização na aplicação
 * @author Marcelo
 *
 */
@Configuration
public class OnAuctionBeans {
	/**
	 * Instância a classe princípal da aplicação, que é utilizada na classe 
	 * <code>OnAuctionApplication</code> que cuida da segurança em nível de método.
	 * @return
	 */
	@Bean
	public Auction auction() {
		return new Auction(buyersUsers());
	}
	/**
	 * Repositório para acesso aos usuários da aplicação.
	 * @return
	 */
	@Bean
	public UserRepository userRepository() {
		return new UserRepository(buyersUsers(), restrictUsers());
	}
	/**
	 * Usuários compradores cadastrados na aplicação.
	 * @return
	 */
	@Bean
	public List<User> buyersUsers() {
		final List<User> buyers = new ArrayList<>();
		buyers.add(new Buyer("0010", "helio", new Login("helio","$2a$06$L3FpkE4Zl0FgXpqTtiUuNuI10raicIv0PqkapqN3hxrenCPrlHSOa")));
		buyers.add(new Buyer("0011", "sabrina", new Login("sabrina","$2a$06$l.5bndH7ONi6Ci6JlP/rWu671845EsltzZwtOfMaVJIiXYAwDSMSa")));
		buyers.add(new Buyer("0012", "julia", new Login("julia","$2a$06$cUyrzi5HeGuuati8IP3sFe20ZxpWRyb/8ARwWvQ1bXcjduSr0P7tS")));
		buyers.add(new Buyer("0013", "ruy", new Login("ruy","$2a$06$Pm1O9C5UmQHMJasDAqeeWuKsPEc/Fmly994JAmg3PX6TlrfKtwSUi")));
		return buyers;
	}
	/**
	 * Usuários administradores e leiloerios cadastrados na aplicação.
	 * @return
	 */
	@Bean
	public List<User> restrictUsers() {
		final List<User> users = new ArrayList<>();
		users.add(new Admin("admin", new Login("admin","$2a$05$Z9rDVGxDp5fG1gVwlZk9BO8uuEyZbgH2FxKMR1xmuX6E0t.ValGXy")));
		users.add(new Auctioneer("auctioneer", new Login("auctioneer","$2a$06$J8e/VtGx0cUu5xEbAKIdgOTHTFdyBYp35gFysDSJr4i55syakGUFq")));
		return users;
	}
	
}
