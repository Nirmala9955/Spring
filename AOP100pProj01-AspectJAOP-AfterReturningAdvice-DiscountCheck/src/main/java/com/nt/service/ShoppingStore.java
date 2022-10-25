package com.nt.service;

import org.springframework.stereotype.Service;

@Service("shopping")
public class ShoppingStore {
	
	public float shopping(String items[], float prices[]) {
		float billAmount = 0.0f;
		for (float p : prices) 
			billAmount=billAmount+p;
		return billAmount;
	}
}
