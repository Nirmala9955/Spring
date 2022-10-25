package com.nt.service;

public class ShoppingStore {
	
	public float shopping(String items[], float prices[]) {
		float billAmount = 0.0f;
		for (float p : prices) 
			billAmount=billAmount+p;
		return billAmount;
	}
}
