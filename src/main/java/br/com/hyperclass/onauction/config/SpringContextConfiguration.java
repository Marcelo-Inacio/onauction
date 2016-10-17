/*
 * @(#)SpringContextConfiguration.java 1.0 23/09/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * A classe <code>SpringContextConfiguration</code> representa a configuracao do
 * contexto do Spring da aplicacao.
 * 
 */
@Configuration
@ComponentScan("br.com.hyperclass.onauction.util")
//@Import(CaixaEletronicoBeans.class)
public class SpringContextConfiguration {
}