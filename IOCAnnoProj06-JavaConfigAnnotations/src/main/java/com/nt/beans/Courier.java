package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;

public interface Courier {
	
	public String deliver(int orderId);
	
}
