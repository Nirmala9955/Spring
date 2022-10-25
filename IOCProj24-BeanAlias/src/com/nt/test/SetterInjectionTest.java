package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		Resource res = null;
		BeanFactory factory=null;
		WishMessageGenerator generator=null, generator1=null;
		
		//hold name and location of spring bean configuration file
		res = new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//create BeanFactory/ IOC container
		factory = new XmlBeanFactory(res);
		//get Target bean class object & Type casting
		generator = (WishMessageGenerator)factory.getBean("wmg1");
		//invoke the method & result
		System.out.println("Wish Message is : "+generator.generateWishMessage("Nimu"));
		System.out.println("-------------------------------------");
		generator = factory.getBean("msg2", WishMessageGenerator.class);
		//invoke the method & result
		System.out.println("Wish Message is : "+generator.generateWishMessage("Niru"));
	}

}
