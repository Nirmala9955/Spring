package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

@Named("fpkt")
public final class Flipkart {
	
	/*@Inject
	@Named("bDart")*/
	@Resource(name = "bDart")
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart : Flipkart()");
	}	

	public String shopping(String[] items, float[] prices)  {
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
