package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Setter;

@Setter
public class Voter implements InitializingBean, DisposableBean {
	private String name;
	private int age;
	private Date dov;

	public Voter() {
		System.out.println("Voter : Voter()");
	}

	/*//initialization event
	public void myInit() {
		System.out.println("Voter : myInti()");
		dov = new Date(); //initializing left over properties
		boolean flag = false;
		if (name==null || name=="") {	//validation
			System.out.println("Null is not allow, you have to pass you name");
			flag = true;
		}
		if (age<0)
			age = age*-1;	//Post processing
		if (age>100) {
			System.out.println("The age limit is between 100");
			flag = true;
		}
		if (flag) 
			throw new IllegalArgumentException("Invalid inputs, try to provide correct inputs");
	}
	
	//Destruction event
	public void myDestroy() {
		System.out.println("Voter : myDestroy()");
		//Nullify all values
		name = null;
		age = 0;
		dov = null;
	}*/

	// Business Method
	public String checkVotingEligibility() {
		System.out.println("Voter : checkVotingEligibility()");
		if (age >= 18)
			return "Mr/ Miss/ Mrs " + name + " your age is " + age
					+ ".\nYou are eligible for vote.\nValidation checking date is " + dov;
		else
			return "Mr/ Miss/ Mrs " + name + " your age is " + age
					+ ".\nYou are not eligible for vote./n Validation checking date is " + dov;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Voter : afterPropertiesSet()");
		dov = new Date(); // initializing left over properties
		boolean flag = false;
		if (name == null || name == "") { // validation
			System.out.println("Null is not allow, you have to pass you name");
			flag = true;
		}
		if (age < 0)
			age = age * -1; // Post processing
		if (age > 100) {
			System.out.println("The age limit is between 100");
			flag = true;
		}
		if (flag)
			throw new IllegalArgumentException("Invalid inputs, try to provide correct inputs");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Voter : destroy()");
		// Nullify all values
		name = null;
		age = 0;
		dov = null;
	}

	
}
