package br.com.hyperclass.onauction.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanRetriever implements ApplicationContextAware {

private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(final ApplicationContext ctx) throws BeansException {
		context = ctx;
	}

	public static <T> T getBean(final String name, final Class<T> clazz) {
		return context.getBean(name, clazz);
	}

}
