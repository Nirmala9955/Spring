package com.nt.service;

public class CarShowRoom {
	
	public String sale(String model, float price, String executive) {
		if (model.equalsIgnoreCase("baleno") || model.equalsIgnoreCase("briza"))
			return model+" car is sold out having "+price+" by executive "+executive;
		else
			return model+" car is not available for sale";
	}

}

