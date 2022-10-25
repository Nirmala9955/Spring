package com.nt.factory;

import com.nt.components.ApolloTyre;
import com.nt.components.BudgetCar;
import com.nt.components.CEATTyre;
import com.nt.components.Car;
import com.nt.components.LuxuryCar;
import com.nt.components.MRFTyre;
import com.nt.components.SportsCar;
import com.nt.components.Tyre;

public class CarFactory {

	// Factory method
	public static Car getInstance(String type) {
		Tyre tyre = null;
		Car car = null;
		if (type.equalsIgnoreCase("luxury")) {
			tyre = new CEATTyre();
			car = new LuxuryCar(tyre);
		} else if (type.equalsIgnoreCase("sports")) {
			tyre = new MRFTyre();
			car = new SportsCar(tyre);
		} else if (type.equalsIgnoreCase("budget")) {
			tyre = new ApolloTyre();
			car = new BudgetCar(tyre);
		} else {
			throw new IllegalArgumentException("Invalied car type you are providing");
		}
		return car;
	} // method

} // class
