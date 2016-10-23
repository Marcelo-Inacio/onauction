package br.com.hyperclass.onauction.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.hyperclass.onauction.domain.auction.Auction;
import br.com.hyperclass.onauction.domain.user.Admin;
import br.com.hyperclass.onauction.domain.user.Buyer;
import br.com.hyperclass.onauction.domain.user.Login;
import br.com.hyperclass.onauction.domain.user.User;

@Configuration
public class OnAuctionBeans {

	@Bean
	public Auction auction() {
		return new Auction(buyersUsers());
	}
	
	@Bean
	public Map<String, Buyer> buyersUsers() {
		final Map<String, Buyer> buyers = new HashMap<>();
		buyers.put("0010", new Buyer("0010", "Helio", new Login("helio@auction.com","123")));
		buyers.put("0011", new Buyer("0011", "Sabrina", new Login("sabrina@auction.com","123")));
		buyers.put("0012", new Buyer("0012", "Julia", new Login("julia@auction.com","123")));
		buyers.put("0013", new Buyer("0013", "Ruy", new Login("ruy@auction.com","123")));
		return buyers;
	}
	
	@Bean
	public Map<String, User> restrictUsers() {
		final Map<String, User> users = new HashMap<>();
		users.put("admin", new Admin("admin", new Login("admin","admin")));
		users.put("auctioneer", new Admin("auctioneer", new Login("auctioneer","auctioneer")));
		return users;
	}
	
}
