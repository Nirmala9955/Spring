package com.nt.components;

public class BudgetCar implements Car {
	
	private Tyre tyre;
	
	public BudgetCar(Tyre tyre) {
		System.out.println("BudgetCar : BudgetCar(-)");
		this.tyre = tyre;
	}
	@Override
	public void drive() {
		System.out.println("Driving Budget car having "+tyre.roadGrip());
	}

}
