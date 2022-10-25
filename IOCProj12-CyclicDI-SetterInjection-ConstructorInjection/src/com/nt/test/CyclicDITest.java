package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.A;
import com.nt.beans.B;

public class CyclicDITest {
	
	public static void main(String[] args) {
		BeanFactory factory = null;
		A a1 = null;
		B b1 = null;
		//Create BeanFactory [IoC] container
		factory = new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//get Beans class object
		a1 = factory.getBean("a1", A.class);
		System.out.println(a1);
		b1 = factory.getBean("b1", B.class);
		System.out.println(b1);
	} 

}
