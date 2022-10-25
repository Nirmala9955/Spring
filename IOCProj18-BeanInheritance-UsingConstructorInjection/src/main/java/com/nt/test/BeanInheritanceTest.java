package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Car;

public class BeanInheritanceTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		Car car1=null, car2=null, car3=null;
		//Create Bean Factory IoC Container 
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//create PersonInfo class object
		car1 = factory.getBean("rajaCar1", Car.class);
		System.out.println(car1);
		System.out.println("--------------------------------------");
		car2 = factory.getBean("rajaCar2", Car.class);
		System.out.println(car2);
	}

}
