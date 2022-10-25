package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("vehicle")
@Lazy
public class Vehicle {
	
	@Value("${dependency.id}")
	private String beanId;
	
	public Vehicle() {
		System.out.println("Vehicle : Vehicle()");
	}

	public void entertainment() {
		System.out.println("Vechicle is equipped with DVD player for entertainment");
	}
	public void soundHorn() {
		System.out.println("Vechicle is equipped with skoda horn");
	}
	
	public void fillFuel() {
		System.out.println("Vechicle is having fuel tank of 60 liters");
	}
	
	/*//version 1
	public void jouney(String sourcePlace, String destPlace) {
		ApplicationContext ctx = null;
		Engine engg = null;
		//Create BeanFactory or IoC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get dependent bean class object
		engg = ctx.getBean(beanId, Engine.class);
		engg.start();
		System.out.println("Journey started from : "+sourcePlace);
		System.out.println("Journey was going on from "+sourcePlace+" to "+destPlace);
		System.out.println("Journey stoped at : "+destPlace);
	}*/

	/*//version 2
	public void jouney(String sourcePlace, String destPlace, ApplicationContext ctx) {
		Engine engg = null;
		//get dependent bean class object
		engg = ctx.getBean(beanId, Engine.class);
		engg.start();
		System.out.println("Journey started from : "+sourcePlace);
		System.out.println("Journey was going on from "+sourcePlace+" to "+destPlace);
		System.out.println("Journey stoped at : "+destPlace);
	}*/
	
	//version 3
	public void jouney(String sourcePlace, String destPlace, ApplicationContext ctx, String beanId) {
		Engine engg = null;
		//get dependent bean class object
		engg = ctx.getBean(beanId, Engine.class);
		engg.start();
		System.out.println("Journey started from : "+sourcePlace);
		System.out.println("Journey was going on from "+sourcePlace+" to "+destPlace);
		System.out.println("Journey stoped at : "+destPlace);
	}
	
}
