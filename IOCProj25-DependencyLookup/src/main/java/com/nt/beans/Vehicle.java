package com.nt.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class Vehicle {
	
	private String beanId;
	
	public Vehicle(String beanId) {
		System.out.println("Vehicle : Vehicle(-)");
		this.beanId = beanId;
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
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		Engine engg = null;
		//Create BeanFactory or IoC container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get dependent bean class object
		engg = factory.getBean("engg", Engine.class);
		engg.start();
		System.out.println("Journey started from : "+sourcePlace);
		System.out.println("Journey was going on from "+sourcePlace+" to "+destPlace);
		System.out.println("Journey stoped at : "+destPlace);
	}
	
}
