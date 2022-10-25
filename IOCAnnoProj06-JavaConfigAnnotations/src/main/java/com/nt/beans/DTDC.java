package com.nt.beans;

import javax.inject.Named;

@Named("dtdc")
public final class DTDC implements Courier {

	public DTDC() {
		System.out.println("DTDC : DTDC()");
	}

	@Override
	public String deliver(int orderId) {
		return "DTDC courier will deliver Order Id : "+orderId+" order products";
	}

}
