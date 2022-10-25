package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.PersonInfo;

public class NullInjectionTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		PersonInfo ram=null, hari=null;
		//Create Bean Factory IoC Container 
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//create PersonInfo class object
		ram = factory.getBean("ramInfo", PersonInfo.class);
		System.out.println(ram);
		System.out.println("--------------------------------------");
		hari = factory.getBean("hariInfo", PersonInfo.class);
		System.out.println(hari);
	}

}
