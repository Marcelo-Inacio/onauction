/*
 * @(#)SecurityConfig.java 1.0 15/10/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * A classe <code>SecurityConfig</code> representa a configuracao de seguranca da aplicacao em nivel de URI
 * @author Marcelo
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/hello").hasRole("ADMIN")
		.and()
		.csrf().disable();
		
	}
	
}
