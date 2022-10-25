package com.nt.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("fFlight")
@Scope("prototype")
public final class FirstFlight implements Courier {
	
	public FirstFlight() {
		System.out.println("FirstFlight : BlueDart()");
	}

	@Override
	public String deliver(int orderId) {
		return "FirstFlight courier will deliver Order Id : "+orderId+" order products";
	}

}
