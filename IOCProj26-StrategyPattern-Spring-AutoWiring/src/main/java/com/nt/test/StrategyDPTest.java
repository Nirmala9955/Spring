package com.nt.test;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.components.Courier;
import com.nt.components.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		Resource res = null;
		BeanFactory factory = null;
		Flipkart fpkt = null;
		//hold the location of the spring configuration file
		res = new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		//create Bean Factory container [IoC container]
		factory = new XmlBeanFactory(res);
		//generate target class object
		//fpkt = (Flipkart) factory.getBean("fpkt");
		fpkt = factory.getBean("fpkt", Flipkart.class);
		//invoke the method
		System.out.println(fpkt.shopping(new String[] {"PPT", "Mask", "Senitizer"}, 
				new float[] {500, 200, 350})
				);
	}

}
