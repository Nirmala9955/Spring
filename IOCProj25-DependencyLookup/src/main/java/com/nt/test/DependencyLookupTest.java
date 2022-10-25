package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Vehicle;

public class DependencyLookupTest {
	
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		Vehicle vechicle=null;
		//Create BeanFactory or IoC container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get dependent bean class object
		vechicle = factory.getBean("vechicle", Vehicle.class);
		//invoke methdos
		vechicle.jouney("Odisha", "Hyd");
		vechicle.entertainment();
		vechicle.soundHorn();
		vechicle.fillFuel();
	}
	
}
