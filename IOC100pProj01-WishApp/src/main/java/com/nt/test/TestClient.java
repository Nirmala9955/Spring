package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class TestClient {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		WishMessageGenerator generator = null;
		//create IoC container
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// get Target bean class object
		generator = ctx.getBean("wmg", WishMessageGenerator.class); 
		// invoke the method
		System.out.println("Wish Message is : " + generator.generateWishMessage("Nimu"));
		
		((AbstractApplicationContext) ctx).close();

	}

}
