/*
 * @(#)OnAuctionWebApplicationInitializer.java 1.0 23/09/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.onauction.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * A classe <code>OnAuctionWebApplicationInitializer</code> representa a configuracao de
 * inicializacao do Spring na aplicacao.
 * 
 */
public class OnAuctionWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/** {@inheritDoc} */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SpringContextConfiguration.class};
	}

	/** {@inheritDoc} */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebConfig.class};
	}

	/** {@inheritDoc} */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/*"};
	}
	
	/** {@inheritDoc} *//*
	@Override
    protected Filter[] getServletFilters() {
        final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setForceEncoding(true);
        encodingFilter.setEncoding("UTF-8");

        return new Filter[] {encodingFilter};
    }*/
	
	@Override
    public void onStartup(final ServletContext context) throws ServletException {
        super.onStartup(context);
        context.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class).addMappingForUrlPatterns(null, false, "/*");
    }

}
