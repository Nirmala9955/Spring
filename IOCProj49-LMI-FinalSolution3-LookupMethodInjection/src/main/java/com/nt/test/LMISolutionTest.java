package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WebContainer;

public class LMISolutionTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		WebContainer wc = null;
		//Create ioc container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Target class bean object
		wc = ctx.getBean("container", WebContainer.class);
		wc.processRequest("hello");
		System.out.println("-----------------");
		wc.processRequest("hai");
		System.out.println("-----------------");
		wc.processRequest("123");
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}
	
}
