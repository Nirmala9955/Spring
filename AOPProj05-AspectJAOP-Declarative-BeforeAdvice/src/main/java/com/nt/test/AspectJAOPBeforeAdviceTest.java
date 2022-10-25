package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CarShowRoom;

public class AspectJAOPBeforeAdviceTest {

	public static void main(String[] args) {
		//create IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class object
		CarShowRoom proxy = ctx.getBean("showRoom", CarShowRoom.class);
		//invoke method
		System.out.println(proxy.sale("briza", 1200000, "Harish"));
		//close container
		((AbstractApplicationContext) ctx).close();
	}
	
}
