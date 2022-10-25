package com.nt.test;

public class NewInstanceTest1 {

	public static void main(String[] args) {
		Class class1 = null, class2 = null;
		Object object1 = null, object2 = null;

		try {
			// load the class
			class1 = Class.forName(args[0]);
			// instantiate the loaded class
			object1 = class1.newInstance();
			System.out.println(object1);
			System.out.println("----------------------------------");
			// load the class
			class2 = Class.forName(args[1]);
			// instantiate the loaded class
			object2 = class2.newInstance();
			System.out.println(object2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}// main

}// class
