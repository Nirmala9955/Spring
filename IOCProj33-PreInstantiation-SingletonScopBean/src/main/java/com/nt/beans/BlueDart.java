package com.nt.beans;

public final class BlueDart implements Courier {
	
	public BlueDart() {
		System.out.println("BlueDart : BlueDart()");
	}

	@Override
	public String deliver(int orderId) {
		return "BlueDart courier will deliver Order Id : "+orderId+" order products";
	}

}
