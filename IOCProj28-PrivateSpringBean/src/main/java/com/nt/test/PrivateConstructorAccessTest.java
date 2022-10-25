package com.nt.test;

import java.lang.reflect.Constructor;

import com.nt.beans.TestBean;

public class PrivateConstructorAccessTest {

	public static void main(String[] args) {
		Class c = null;
		Constructor cons[]= null;
		TestBean b1=null, b2=null;
		Object obj = null;
		try {
			//load the class
			c = Class.forName("com.nt.beans.TestBean");
			//get all declared constructors
			cons = c.getDeclaredConstructors();
			//create object for that class
			cons[0].setAccessible(true);
			b1 = (TestBean)cons[0].newInstance();
			System.out.println(b1);
			System.out.println("-----------------------");
			cons[1].setAccessible(true);
			b2 = (TestBean)cons[1].newInstance(10,30);
			System.out.println(b2);
			System.out.println("------------------------"); 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
