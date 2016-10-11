package br.com.hyperclass.onauction.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * A classe <code>SpringContextConfiguration</code> representa a configuracao do
 * contexto do Spring da aplicacao.
 *
 * 
 */
@Configuration
@ComponentScan("br.com.hyperclass.onauction.util")
//@Import(CaixaEletronicoBeans.class)
public class SpringContextConfiguration {
}