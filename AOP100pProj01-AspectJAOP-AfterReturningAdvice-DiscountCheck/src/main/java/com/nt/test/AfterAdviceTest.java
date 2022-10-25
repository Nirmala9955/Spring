package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.ShoppingStore;

public class AfterAdviceTest {
	
	public static void main(String[] args) {
		//create IoC container
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//get Proxy object
		ShoppingStore storeProxy = ctx.getBean("shopping", ShoppingStore.class);
		//invoke method
		System.out.println("Bill Aount: "+storeProxy.shopping(new String[] {"shirt", "Trouser", "Belt" }, new float[] {5000, 3000, 1000}));
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}
	
}
