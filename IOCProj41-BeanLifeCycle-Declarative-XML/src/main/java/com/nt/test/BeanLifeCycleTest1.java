package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Voter;

public class BeanLifeCycleTest1 {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		Voter voter = null;
		//Create IoC Container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Bean
		voter = factory.getBean("voter", Voter.class);
		System.out.println(voter.checkVotingEligibility());
		
		//close container
		factory.destroySingletons();
	}

}
