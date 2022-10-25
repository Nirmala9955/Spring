package com.nt.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dtdc")
//@Primary
public final class DTDC implements Courier {

	public DTDC() {
		System.out.println("DTDC : DTDC()");
	}

	@Override
	public String deliver(int orderId) {
		return "DTDC courier will deliver Order Id : "+orderId+" order products";
	}

}
