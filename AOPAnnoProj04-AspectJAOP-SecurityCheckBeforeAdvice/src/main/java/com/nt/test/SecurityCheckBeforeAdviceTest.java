package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.manager.AuthenticationManager;
import com.nt.service.IBankService;


public class SecurityCheckBeforeAdviceTest {

	public static void main(String[] args) {
		//create IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class object
		IBankService service = ctx.getBean("bankService", IBankService.class);
		//get AuthenticationManager obejct
		AuthenticationManager manager = ctx.getBean("authManager", AuthenticationManager.class); 
		//invoke method
		try {
			manager.signIn("nimu", "nimu@123");
			System.out.println("Deposit operation: "+service.depositMoney(1001, 10000));
			System.out.println("Withdraw operation: "+service.withdrawMoney(1001, 2000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}
	
}
