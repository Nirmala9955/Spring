package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class SpringAOPDeclarativeTest {

	public static void main(String[] args) {
		//Creat IoC container
		BankService proxy = null;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service bean
		proxy = ctx.getBean("pfb", BankService.class);
		System.out.println("Interest amount: "+proxy.calculateSimpleIntrestAmount(100000, 2, 12));
	}

}
