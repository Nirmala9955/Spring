package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.EnggCourse;

public class CollectionMergingTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		EnggCourse course = null;
		//Create Bean Factory IoC Container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get beans
		course = factory.getBean("com.nt.beans.EnggCourse#0", EnggCourse.class);
		System.out.println(course);
		System.out.println("--------------------------------------");
		course = factory.getBean("com.nt.beans.EnggCourse#1", EnggCourse.class);
		System.out.println(course);
		System.out.println("--------------------------------------");
		course = factory.getBean("com.nt.beans.EnggCourse#2", EnggCourse.class);
		System.out.println(course);
	}

}
