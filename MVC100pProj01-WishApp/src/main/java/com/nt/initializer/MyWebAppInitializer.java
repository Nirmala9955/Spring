package com.nt.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCConfig;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {
		//will be used by super class onStartup(-) to get Configuration class name  for Parent IoC container
		return new Class[] {RootAppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//will be used by super class onStartup(-) to get Configuration class name  for child IoC container
				return new Class[] {WebMVCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		//Will be used by super class onStartup(-) to get DC URL pattern
		return new String[] {"/"};
	}

}
