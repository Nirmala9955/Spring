package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCConfig;

public class MyWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		// create Parent IoC container
		AnnotationConfigWebApplicationContext parentCtx = new AnnotationConfigWebApplicationContext();
		parentCtx.register(RootAppConfig.class);
		//create contextLoaderListener
		ContextLoaderListener listener = new ContextLoaderListener(parentCtx);
		//register listener with container
		sc.addListener(listener);

		//create child IoC container
		AnnotationConfigWebApplicationContext childCtx = new AnnotationConfigWebApplicationContext();
		childCtx.register(WebMVCConfig.class);
		//create DispatcherServlet class object
		DispatcherServlet servlet = new DispatcherServlet(childCtx);
		//register DS with servlet container
		ServletRegistration.Dynamic registration = sc.addServlet("ds", servlet);
		//provide url pattern
		registration.addMapping("/");
		registration.setLoadOnStartup(2);
	}

}
