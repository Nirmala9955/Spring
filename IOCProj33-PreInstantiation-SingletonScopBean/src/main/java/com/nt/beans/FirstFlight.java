package com.nt.beans;

public final class FirstFlight implements Courier {
	
	public FirstFlight() {
		System.out.println("FirstFlight : FistFlight()");
	}

	@Override
	public String deliver(int orderId) {
		return "FirstFlight courier will deliver Order Id : "+orderId+" order products";
	}

}
