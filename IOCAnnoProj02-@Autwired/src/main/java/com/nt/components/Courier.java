package com.nt.components;

import org.springframework.beans.factory.annotation.Autowired;

public interface Courier {
	
	public String deliver(int orderId);
	
}
