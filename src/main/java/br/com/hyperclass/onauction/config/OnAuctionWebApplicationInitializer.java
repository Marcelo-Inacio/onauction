package br.com.hyperclass.onauction.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OnAuctionWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebApplicationInitializer {

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
	
	/** {@inheritDoc} */
	@Override
    protected Filter[] getServletFilters() {
        final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setForceEncoding(true);
        encodingFilter.setEncoding("UTF-8");

        return new Filter[] {encodingFilter};
    }
	
	@Override
    public void onStartup(final ServletContext context) throws ServletException {
        super.onStartup(context);
        //context.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class).addMappingForUrlPatterns(null, false, "/*");
    }

}
