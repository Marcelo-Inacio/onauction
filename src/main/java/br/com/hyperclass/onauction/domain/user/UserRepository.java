package br.com.hyperclass.onauction.domain.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
	
	private Map<String, User> users = new HashMap<>();
	
	public User getByUsername(final String username) {
		return users.get(username);
	}
	
	@Resource
	public void setUsers(@Qualifier("restrictUsers") final Map<String, User> restricts) {
		for(final User user : restricts.values()) {
			final Login login = user.getLogin();
			users.put(login.getUsername(), user);
		}
	}
	
	//@Resource
	public void setBuyers(@Qualifier("buyersUsers") final Map<String, User> buyers) {
		for(final User user : buyers.values()) {
			final Login login = user.getLogin();
			users.put(login.getUsername(), user);
		}
	}
	
	/*
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
	 */
	
}
