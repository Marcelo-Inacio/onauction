/*
 * @(#)UserRepository.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.domain.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.hyperclass.onauction.domain.auction.AuctionException;
/**
 * A classe <code>UserRepository</code> representa um repositório que
 * contém os registros de todos os usuários do leilão.
 * 
 * @author Marcelo
 *
 */
public class UserRepository {
	
	private Map<String, User> users = new HashMap<>();

	public UserRepository(final List<User> buyers, final List<User> restrict) {

		loadUsers(buyers, restrict);
	}
	/**
	 * Método que recupera um usuário, a partir do username fornecido.
	 * @param username
	 * @return
	 * @throws AuctionException
	 */
	public User getByUsername(final String username) throws AuctionException {
		final User userFound = users.get(username);
		if(userFound == null) {
			throw new UserNotFoundException(username); 
		}
		return userFound;
	}
	/**
	 * Método que trata de carregar na memória todos os usários que tem acesso ao leilão.
	 * @param buyers
	 * @param restrict
	 */
	private void loadUsers(final List<User> buyers, final List<User> restrict) {
		for(final User user : buyers) {
			final Login login = user.getLogin();
			this.users.put(login.getUsername(), user);
		}
		for(final User user : restrict) {
			final Login login = user.getLogin();
			this.users.put(login.getUsername(), user);
		}
	}
	
}
