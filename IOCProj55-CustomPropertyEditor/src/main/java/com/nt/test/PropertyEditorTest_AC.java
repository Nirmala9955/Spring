package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.LoanAmountInterestCalculator;

public class PropertyEditorTest_AC {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		LoanAmountInterestCalculator lamount = null;
		//Create Container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get bean object
		lamount = ctx.getBean("laiCalculator", LoanAmountInterestCalculator.class);
		//invoke method
		System.out.println("Interest amount : "+lamount.calculateInterestAmount());
		
		((AbstractApplicationContext) ctx).close();
	}
	
}
