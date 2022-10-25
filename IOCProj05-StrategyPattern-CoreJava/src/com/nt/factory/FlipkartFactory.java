package com.nt.factory;

import com.nt.components.BlueDart;
import com.nt.components.Courier;
import com.nt.components.DTDC;
import com.nt.components.FirstFlight;
import com.nt.components.Flipkart;

public class FlipkartFactory {
	
	public static Flipkart getInstane(String courierName) {
		Courier courier=null;
		Flipkart fpkt=null;
		if (courierName.equalsIgnoreCase("dtdc")) 
			courier = new DTDC();
		else  if (courierName.equalsIgnoreCase("blueDart"))
			courier = new BlueDart();
		else  if (courierName.equalsIgnoreCase("firstFlight"))
			courier = new FirstFlight();
		else 
			throw new IllegalArgumentException("Invalid courier name");
		
		//create target class object
		fpkt=new Flipkart();
		//assign dependent class object to target class object
		fpkt.setCourier(courier);
		return fpkt;
	}

}
