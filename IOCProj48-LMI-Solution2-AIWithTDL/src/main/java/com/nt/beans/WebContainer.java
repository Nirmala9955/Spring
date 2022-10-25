package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebContainer implements ApplicationContextAware {
	
	private String beanId;
	private ApplicationContext ctx = null;
	
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("WebContainer : setApplicationContext(-)");
		this.ctx = ctx;
	}
	
	public WebContainer() {
		System.out.println("WebContainer : WebContainer()");
	}
	
	public void processRequest(String data) {
		System.out.println("WebContainer is processing request with data : "+data+" by giving it to handler.");
		RequestHandler handler = null;
		//get Dependent object using dependency lookup
		handler = ctx.getBean(beanId, RequestHandler.class);
		handler.handleRequest(data);
	}

	
	
}
