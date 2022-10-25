package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebContainer {
	
	private String beanId;
	
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public WebContainer() {
		System.out.println("WebContainer : WebContainer()");
	}
	
	public void processRequest(String data) {
		System.out.println("WebContainer is processing request with data : "+data+" by giving it to handler.");
		ApplicationContext ctx = null;
		RequestHandler handler = null;
		//Create extra IoC containe
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Dependent object using dependency lookup
		handler = ctx.getBean(beanId, RequestHandler.class);
		handler.handleRequest(data);
	}
	
}
