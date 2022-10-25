package com.nt.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceTest2 {

	public static void main(String[] args) {
		Class class1 = null;
		Object object1 = null;
		Constructor cons[] = null;

		try {
			// load the class
			class1 = Class.forName(args[0]);
			// get all Constructor of the loaded class
			cons = class1.getDeclaredConstructors();
			// instantiate the loaded class
			object1 = cons[0].newInstance(10, 20);
			System.out.println(object1);
			System.out.println("----------------------------------");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}// main

}// class
