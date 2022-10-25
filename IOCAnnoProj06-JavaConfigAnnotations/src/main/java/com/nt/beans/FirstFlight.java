package com.nt.beans;

import javax.inject.Named;

@Named("fFlight")
public final class FirstFlight implements Courier {
	
	public FirstFlight() {
		System.out.println("FirstFlight : BlueDart()");
	}

	@Override
	public String deliver(int orderId) {
		return "FirstFlight courier will deliver Order Id : "+orderId+" order products";
	}

}
