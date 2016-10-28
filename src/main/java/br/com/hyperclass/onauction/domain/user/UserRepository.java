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

public class UserRepository {
	
	private Map<String, User> users = new HashMap<>();

	public UserRepository(final List<User> buyers, final List<User> restrict) {

		loadUsers(buyers, restrict);
	}
	
	public User getByUsername(final String username) {
		return users.get(username);
	}
	
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
