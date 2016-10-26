package br.com.hyperclass.onauction.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.hyperclass.onauction.domain.user.Login;
import br.com.hyperclass.onauction.domain.user.UserRepository;

@Component
public class DefaultUserDetails implements UserDetailsService {
	
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final br.com.hyperclass.onauction.domain.user.User user = repository.getByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User '" + username + "' not found.");
		}
		final Login login = user.getLogin();
		final List<GrantedAuthority> roles = new ArrayList<>(2); 
		roles.add(new DefaultGrantedAuthority(user.getProfile()));
		return new User(login.getUsername(), login.getUsername(), roles);
	}
	
	@Autowired
	public void setUserRepository(final UserRepository userRepository) {
		this.repository = userRepository;
	}

}
