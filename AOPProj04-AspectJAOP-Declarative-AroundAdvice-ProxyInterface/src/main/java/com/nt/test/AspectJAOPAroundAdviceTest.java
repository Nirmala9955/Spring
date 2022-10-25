package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankService;

public class AspectJAOPAroundAdviceTest {

	public static void main(String[] args) {
		//create IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class object
		IBankService proxy = ctx.getBean("bankService", IBankService.class);
		//System.out.println("Proxy object class name: "+proxy.getClass());
		//invoke method on Proxy object
		System.out.println("Intrest amount is : "+proxy.calculateSimpleIntrestAmount(100000, 2, 12));
		System.out.println("-----------------------------");
		System.out.println("Intrest amount is : "+proxy.calculateCompoundIntrestAmount(100000, 2, 12));
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}
	
}
