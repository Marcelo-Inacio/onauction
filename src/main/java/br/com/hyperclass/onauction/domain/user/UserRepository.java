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
 * A classe <code>UserRepository</code> representa um reposit�rio que
 * cont�m os registros de todos os usu�rios do leil�o.
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
	 * M�todo que recupera um usu�rio, a partir do username fornecido.
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
	 * M�todo que trata de carregar na mem�ria todos os us�rios que tem acesso ao leil�o.
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
