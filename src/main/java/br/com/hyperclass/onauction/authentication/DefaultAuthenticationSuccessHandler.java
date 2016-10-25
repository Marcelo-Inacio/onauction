package br.com.hyperclass.onauction.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class DefaultAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private final List<AuthenticationListener> authenticationListeners = new ArrayList<>();

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication auth)
			throws IOException, ServletException {

		final AuthenticationEvent event = new AuthenticationEvent(response, auth);
        for (final AuthenticationListener listener : authenticationListeners) {
            listener.onAuthenticationSuccess(event);
        }

	}
	
	@Resource
    public void setAuthenticationListeners(final List<AuthenticationListener> authenticationListeners) {
        this.authenticationListeners.addAll(authenticationListeners);
    }

}
