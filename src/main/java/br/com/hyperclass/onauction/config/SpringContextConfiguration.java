/*
 * @(#)SpringContextConfiguration.java 1.0 23/09/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
/**
 * A classe <code>SpringContextConfiguration</code> representa a configuracao do
 * contexto do Spring da aplicacao.
 * 
 */
@Configuration
@ComponentScan({"br.com.hyperclass.onauction.util", "br.com.hyperclass.onauction.domain.batch", 
	"br.com.hyperclass.onauction.application", "br.com.hyperclass.onauction.restapi.serializer",
	"br.com.hyperclass.onauction.domain.user",
	"br.com.hyperclass.onauction.authentication", "br.com.hyperclass.onauction.authentication.jwt"})
@PropertySource("classpath:authentication.properties")
@Import({OnAuctionBeans.class, SecurityConfig.class})
public class SpringContextConfiguration {	
}