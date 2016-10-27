package br.com.hyperclass.onauction.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import br.com.hyperclass.onauction.domain.user.User;
import br.com.hyperclass.onauction.domain.user.UserRepository;

@Component
public class DefaultAuthenticationProvider implements AuthenticationProvider {
	
	private final UserRepository repository;
	
	public DefaultAuthenticationProvider(final UserRepository repository) {
        this.repository = repository;
    }

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		final User user = repository.getByUsername(authentication.getName());
		return new PreAuthenticatedAuthentication(user);
	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return true;//authentication.equals(PreAuthenticatedAuthentication.class);
	}

}
