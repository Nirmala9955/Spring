package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Flipkart fpkt = null;
		//Create IoC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get bean
		//fpkt = ctx.getBean("fpkt", Flipkart.class);		
		//fpkt = ctx.getBean("flipkart", Flipkart.class);		
		fpkt = ctx.getBean(Flipkart.class);		
		// invoke the method
		System.out.println(fpkt.shopping(new String[] { "PPT", "Mask", "Senitizer" }, new float[] { 500, 200, 350 }));
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
