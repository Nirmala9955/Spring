package com.nt.components;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public final class Flipkart {
	
	@Autowired
	//@Qualifier("bDart")
	//@Qualifier("d2")
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart : Flipkart()");
	}	
	
	@Autowired
	public Flipkart(Courier courier) {
		System.out.println("Flipkart : Flipkart(-)");
		this.courier = courier;
	}
	
	@Autowired
	public void setCourier(Courier courier) {
		System.out.println("Flipkart : setCourier(-)");
		this.courier = courier;
	}
	
	@Autowired
	public void assign(Courier courier) {
		System.out.println("Flipkart : assign(-)");
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
