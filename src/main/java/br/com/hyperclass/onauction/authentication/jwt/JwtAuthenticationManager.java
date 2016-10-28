/*
 * @(#)JwtAuthenticationManager.java 1.0 26/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.authentication.jwt;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;

import br.com.hyperclass.onauction.authentication.PreAuthenticatedAuthentication;
import br.com.hyperclass.onauction.domain.user.UserRepository;

@Component
public class JwtAuthenticationManager implements AuthenticationManager {
	
	private final UserRepository repository;
    private final List<JwtVerifier> verifiersList = new ArrayList<>();
    
    @Autowired
    public JwtAuthenticationManager(final UserRepository repository) {
        super();
        this.repository = repository;
    }

	@Override
	public Authentication authenticate(final Authentication auth) throws AuthenticationException {
		final String token = String.valueOf(auth.getPrincipal()).substring(6).trim();
        final JWT jwt;
        final JWTClaimsSet claims;

        try {
            jwt = JWTParser.parse(token);
            claims = jwt.getJWTClaimsSet();
        } catch (final ParseException exception) {
            throw new JwtTokenException("The given JWT could not be parsed.");
        }

        for (final JwtVerifier verifier : verifiersList) {
            verifier.verify(jwt);
        }

        final String username = claims.getSubject();
        return new PreAuthenticatedAuthentication(repository.getByUsername(username));
	}
	
	
	@Resource
    public void setVerifiersList(final List<JwtVerifier> verifiersList) {
        this.verifiersList.addAll(verifiersList);
    }

}
