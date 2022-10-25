package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Vehicle;

public class DependencyLookupTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Vehicle vechicle=null;
		//Create BeanFactory or IoC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get dependent bean class object
		vechicle = ctx.getBean("vechicle", Vehicle.class);
		//invoke methdos
		vechicle.jouney("Odisha", "Hyd");
		vechicle.entertainment();
		vechicle.soundHorn();
		vechicle.fillFuel();
		
		//close the container
		((AbstractApplicationContext) ctx).close();
	}
	
}
