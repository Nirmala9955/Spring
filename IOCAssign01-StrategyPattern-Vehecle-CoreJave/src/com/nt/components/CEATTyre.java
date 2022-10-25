package com.nt.components;

public class CEATTyre implements Tyre {
	
	public CEATTyre() {
		System.out.println("CEATTyre : CEATTyre()");
	}
	
	@Override
	public String roadGrip() {
		return "CEAT Tyre : Smooth Road Grip - Suitable for Luxury and comfort";
	}

}
