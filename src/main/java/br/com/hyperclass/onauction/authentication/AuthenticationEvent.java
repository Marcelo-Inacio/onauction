package br.com.hyperclass.onauction.authentication;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

public class AuthenticationEvent extends AuthenticationSuccessEvent {

	private static final long serialVersionUID = 1L;
	private final HttpServletResponse response;
	
	public AuthenticationEvent(final HttpServletResponse response, final Authentication authentication) {
        super(authentication);
        this.response = response;
    }
	
	@Override
    public PreAuthenticatedAuthentication getAuthentication() {
        return (PreAuthenticatedAuthentication) super.getAuthentication();
    }

    public String getUsername() {
        return getUser().getName();
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    private Principal getUser() {
        return null;//getAuthentication().getPrincipal();
    }

}
