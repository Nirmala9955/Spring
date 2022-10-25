package com.nt.test;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.LoanAmountInterestCalculator;

public class PropertyEditorTest_BF2 {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		CustomEditorConfigurer configure = null;
		LoanAmountInterestCalculator lamount = null;
		//Create Container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//add custom PropertyEditorRegistrer to IoC container
		configure = factory.getBean(CustomEditorConfigurer.class);
		configure.postProcessBeanFactory(factory);
 		//get bean object
		lamount = factory.getBean("laiCalculator", LoanAmountInterestCalculator.class);
		//invoke method
		System.out.println("Interest amount : "+lamount.calculateInterestAmount());
	}

}
