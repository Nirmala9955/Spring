package com.nt.service;

public class ShoppingStore {

	public float generateBill(String[] items, float[] prices) {
		boolean problem=false;
		if (items==null||prices==null)
			problem=true;
		for (float p : prices) {
			if (p<=0.0f) {
				problem=true;
				break;
			}
		}
		if (problem) 
			throw new IllegalArgumentException("Invalid inputs");
		float billAmount=0.0f;
		for (float p : prices) {
			billAmount=billAmount+p;
		}
		return billAmount;
	}
	
}
