package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader  reader = null;
		Flipkart fpkt = null;
		// create Bean Factory container [IoC container]
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		// generate target class object
		fpkt = factory.getBean("fpkt", Flipkart.class);
		// invoke the method
		//System.out.println(fpkt.shopping(new String[] { "PPT", "Mask", "Senitizer" }, new float[] { 500, 200, 350 }));
	}

}
