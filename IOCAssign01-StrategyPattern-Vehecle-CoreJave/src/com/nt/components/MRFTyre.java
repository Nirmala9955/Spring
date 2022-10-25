package com.nt.components;

public class MRFTyre implements Tyre {
	
	public MRFTyre() {
		System.out.println("MRFTyre : MRFTyre()");
	}
	
	@Override
	public String roadGrip() {
		return "MRF Tyre : Super Road Grip - Suitable for Sports";
	}

}
