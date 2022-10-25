package com.nt.components;

public class LuxuryCar implements Car {
	
	private Tyre tyre;
	
	public LuxuryCar(Tyre tyre) {
		System.out.println("LuxuryCar : LuxuryCar(-)");
		this.tyre = tyre;
	}

	@Override
	public void drive() {
		System.out.println("Driving Luxury car having "+tyre.roadGrip());
	}

}
