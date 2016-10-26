/*
 * @(#)SecurityConfig.java 1.0 15/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.config;

import java.util.Arrays;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.hyperclass.onauction.authentication.PreAuthenticatedUserFilter;
import br.com.hyperclass.onauction.authentication.custom.TokenAuthenticationService;

/**
 * A classe <code>SecurityConfig</code> representa a configuracao de seguranca
 * da aplicacao em nivel de URI
 * 
 * @author Marcelo
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("jwtAuthenticationManager")
	private AuthenticationManager jwtAuthenticationManager;

	@Autowired
    @Qualifier("providerManager")
    private AuthenticationManager providerManager;
	
	@Autowired
	@Qualifier("defaultUserDetails")
	private UserDetailsService userDetailsService;
	
	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.addFilter(preAuthenticationFilter());
		//http.addFilter(loginFilter());
		http.addFilter(anonymousFilter());
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/batch/lastBid").permitAll()
		.regexMatchers("/batch/*").authenticated()
		.regexMatchers("/batches").authenticated()
		.anyRequest().authenticated()
		.addFilterBefore(new StatelessLoginFilter("/login", tokenAuthenticationService, userDetailsService, authenticationManager()), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
    public Filter anonymousFilter() {
        return new AnonymousAuthenticationFilter("anonymousUser");
    }
	
	@Bean
	public Filter preAuthenticationFilter() {
		final PreAuthenticatedUserFilter filter = new PreAuthenticatedUserFilter();
		filter.setAuthenticationManager(jwtAuthenticationManager);
		return filter;
	}
	
	@Bean
	public Filter loginFilter() {
		final UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
		filter.setAuthenticationManager(providerManager);
		//filter.setAuthenticationSuccessHandler(successHandler);
		//filter.setAuthenticationFailureHandler(failureHandler);
		return filter;
	}
	@Bean
	public AuthenticationManager providerManager(@Qualifier("defaultAuthenticationProvider") final AuthenticationProvider provider) {
		return new ProviderManager(Arrays.asList(provider));
	}	

	/*
	
	//@Autowired
    private AuthenticationSuccessHandler successHandler;
    /*	
	
	@Bean
    public List<AuthenticationListener> authenticationListeners(
            @Qualifier("responseHeaderAuthenticationListener") final AuthenticationListener responseHeaderListener) {
        final List<AuthenticationListener> list = new ArrayList<>(1);
        list.add(responseHeaderListener);
        return list;
    }
	
	@Bean
    public JwtVerifier jwtSignatureVerifier(@Value("${jwt.secret}") final String secret) throws JOSEException {
        return new JwtSignatureVerifier(secret);
    }
*/

}
