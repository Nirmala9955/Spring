package com.nt.components;

public final class DTDC implements Courier {

	public DTDC() {
		System.out.println("DTDC : DTDC()");
	}

	@Override
	public String deliver(int orderId) {
		return "DTDC courier will deliver Order Id : "+orderId+" order products";
	}

}
