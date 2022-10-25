package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.components.Student;

public class Setter_ConstructorInjectionTest {

	public static void main(String[] args) {
		BeanFactory factory = null;
		Student student = null;
		//Create BeanFactory [IoC] Container
		factory = new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//get Student class Object
		student = factory.getBean("stud", Student.class);
		System.out.println(student);	
	}

}
