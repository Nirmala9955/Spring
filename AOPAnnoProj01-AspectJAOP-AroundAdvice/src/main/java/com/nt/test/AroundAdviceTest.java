package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class AroundAdviceTest {

	public static void main(String[] args) {
		//create IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class object
		BankService proxy = ctx.getBean("bankService", BankService.class);
		//invoke method on Proxy object
		System.out.println("Simple Intrest amount is : "+proxy.calculateSimpleIntrestAmount(100000, 2, 12));
		System.out.println("-----------------------------");
		System.out.println("Compound Intrest amount is : "+proxy.calculateCompoundIntrestAmount(100000, 2, 12));
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}
	
}
