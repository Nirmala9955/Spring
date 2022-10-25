package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.ProfessionalCrickerter;

public class InnerBeansTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		ProfessionalCrickerter cricketer1 = null, cricketer2 = null;
		//Create Bean Factory IoC container 
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get bean
		cricketer1 = factory.getBean("kohil", ProfessionalCrickerter.class);
		System.out.println(cricketer1);
		System.out.println("-----------------------------------------");
		cricketer2 = factory.getBean("dhoni", ProfessionalCrickerter.class);
		System.out.println(cricketer2);
	}

}
