package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.LoanAmountDetails;
import com.nt.beans.LoanAmountInterestCalculator;
import com.nt.editors.LoanAmountDetailsEditor;

public class PropertyEditorTest_BF_LE {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		LoanAmountInterestCalculator lamount = null;
		//Create Container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//add custom PropertyEditorRegistrer to IoC container
		factory.addPropertyEditorRegistrar(registry -> {
				registry.registerCustomEditor(LoanAmountDetails.class, new LoanAmountDetailsEditor());	
		});
 		//get bean object
		lamount = factory.getBean("laiCalculator", LoanAmountInterestCalculator.class);
		//invoke method
		System.out.println("Interest amount : "+lamount.calculateInterestAmount());
	}
	
}
