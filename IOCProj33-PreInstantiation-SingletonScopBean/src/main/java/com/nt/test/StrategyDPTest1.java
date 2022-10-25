package com.nt.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Flipkart;

public class StrategyDPTest1 {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Flipkart fpkt = null;
		// create ApplicationContext container [IoC container]
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// generate target class object
		fpkt = ctx.getBean("fpkt", Flipkart.class);
		// invoke the method
		//System.out.println(fpkt.shopping(new String[] { "PPT", "Mask", "Senitizer" }, new float[] { 500, 200, 350 }));
	}

}
