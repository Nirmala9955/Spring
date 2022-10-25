package com.nt.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("fpkt")
//@Component
@Scope("prototype")
public final class Flipkart {
	
	@Autowired
	@Qualifier("bDart")
	private Courier courier;
	
	@Autowired
	private static Date date;
	
	public Flipkart() {
		System.out.println("Flipkart : Flipkart()");
	}	

	public String shopping(String[] items, float[] prices)  {
		System.out.println("Flipkart : shopping()"+date);
		float billAmount = 0.0f;
		int orderId = 0;
		String msg = null;
		//calculate bill amount
		for (float p : prices) 
			//billAmount = bilAmount+p;
			billAmount+=p;
		
		//Generate order id dynamically as random number
		orderId = new Random().nextInt(10000);
		//use courier service for delivering the products
		msg = courier.deliver(orderId);
		
		return Arrays.toString(items)+" are purchased having prices "+Arrays.toString(prices)+"\nwill bill amount "+billAmount+" ..... \n"+msg;
	}

}
