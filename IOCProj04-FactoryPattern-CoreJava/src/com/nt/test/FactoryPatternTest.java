package com.nt.test;

import com.nt.components.Car;
import com.nt.factory.CarFactory;

public class FactoryPatternTest {

	public static void main(String[] args) {
		Car car = null;
		car = CarFactory.getInstance("luxury");
		car.drive();
		System.out.println("-------------------------");
		car = CarFactory.getInstance("budget");
		car.drive();
	}

}
