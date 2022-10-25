package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ShoppingStore;

public class ThrowsAdviceTest {
	
	public static void main(String[] args) {
		//create IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		ShoppingStore storeProxy = ctx.getBean("shopping", ShoppingStore.class);
		try {
			//invoke method
			System.out.println("Bill Aount: "+storeProxy.generateBill(new String[] {"shirt", "Trouser", "Belt" }, new float[] {5000, 3000, 0}));
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}
	
}
