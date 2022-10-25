	package com.nt.test;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Properties;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class FactoryMethodBeanInstantiationTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		Class clss = null;
		Calendar calender = null;
		Connection conn = null;
		Properties props = null;
		String str1 = null, str2 = null;
		//Create Bean Factory IoC Container
		factory = new  DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get bean class object
		clss = factory.getBean("cls", Class.class);
		System.out.println("Object class name : "+clss.getClass().getName()+"\nGet object data : "+clss.toString());
		System.out.println("-------------------------------");
		calender = factory.getBean("cal", Calendar.class);
		System.out.println("Object class name : "+calender.getClass().getName()+"\nGet object data : "+calender.toString());
		System.out.println("-------------------------------");
		conn = factory.getBean("conn", Connection.class);
		System.out.println("Object class name : "+conn.getClass().getName()+"\nGet object data : "+conn.toString());
		System.out.println("-------------------------------");
		props = factory.getBean("sys", Properties.class);
		System.out.println("Object class name : "+props.getClass().getName()+"\nGet object data : "+props.toString());
		System.out.println("-------------------------------");
		str1 = factory.getBean("s2", String.class);
		System.out.println("Object class name : "+str1.getClass().getName()+"\nGet object data : "+str1.toString());
		System.out.println("-------------------------------");
		str2 = factory.getBean("s3", String.class);
		System.out.println("Object class name : "+str2.getClass().getName()+"\nGet object data : "+str2.toString());
	}

}
