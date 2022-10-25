package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.TestBean;

public class PrivateModifierTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		TestBean bean = null;
		Object obj = null;
		// Create Bean Factory IoC container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get bean class object
		bean = factory.getBean("beans", TestBean.class);
		System.out.println(bean);
		System.out.println("------------------");
		obj = factory.getBean("innerBeans", Object.class);
		System.out.println(obj);
	}

}
