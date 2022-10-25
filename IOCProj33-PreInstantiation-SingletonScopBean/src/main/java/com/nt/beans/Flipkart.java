package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {
	
	//property 
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart : Flipkart()");
	}

	public Flipkart(Courier courier) {
		System.out.println("Flipkart : Flipkart(-)");
		this.courier = courier;
	}

	public String shopping(String[] items, float[] prices)  {
		System.out.println("Flipkart : shopping()");
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
