package br.com.hyperclass.onauction.domain.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	
	private Map<String, User> users;
	
	
	public User getByUsername(final String username) {
		return users.get(username);
	}
	
	@Autowired
	public void setUsers(@Qualifier("buyersUsers") final Map<String, User> buyers,
			@Qualifier("restrictUsers") final Map<String, User> restricts) {
		
		for(final User user : buyers.values()) {
			final Login login = user.getLogin();
			users.put(login.getUsername(), user);
		}
		
		for(final User user : restricts.values()) {
			final Login login = user.getLogin();
			users.put(login.getUsername(), user);
		}
		
	}

}
