package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Vehicle implements ApplicationContextAware {
	
	private String beanId;
	private ApplicationContext ctx = null;
	
	public Vehicle(String beanId) {
		System.out.println("Vehicle : Vehicle(-)");
		this.beanId = beanId;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Vehicle.setApplicationContext()");
		this.ctx = ctx;		
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
	
	public void jouney(String sourcePlace, String destPlace) {
		Engine engg = null;
		//get dependent bean class object
		engg = ctx.getBean(beanId, Engine.class);
		engg.start();
		System.out.println("Journey started from : "+sourcePlace);
		System.out.println("Journey was going on from "+sourcePlace+" to "+destPlace);
		System.out.println("Journey stoped at : "+destPlace);
	}
	
}
