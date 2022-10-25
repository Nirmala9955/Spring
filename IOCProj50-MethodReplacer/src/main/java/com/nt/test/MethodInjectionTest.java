package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.BankLoanMgmt;

public class MethodInjectionTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankLoanMgmt bank = null;
		//Create IoC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Target class bean
		bank = ctx.getBean("bank", BankLoanMgmt.class);
		//invoke method
		System.out.println("Interest amount: "+bank.calculateInterestAmount(100000, 2, 12));
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

} 