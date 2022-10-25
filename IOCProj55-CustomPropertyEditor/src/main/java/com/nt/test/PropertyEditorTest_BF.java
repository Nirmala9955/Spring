package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.LoanAmountDetails;
import com.nt.beans.LoanAmountInterestCalculator;
import com.nt.editors.LoanAmountDetailsEditor;

public class PropertyEditorTest_BF {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		LoanAmountInterestCalculator lamount = null;
		//Create Container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//add custom PropertyEditorRegistrer to IoC container
		factory.addPropertyEditorRegistrar(new CustomRegistrar());
 		//get bean object
		lamount = factory.getBean("laiCalculator", LoanAmountInterestCalculator.class);
		//invoke method
		System.out.println("Interest amount : "+lamount.calculateInterestAmount());
	}

	private static class CustomRegistrar implements PropertyEditorRegistrar {
		@Override
		public void registerCustomEditors(PropertyEditorRegistry registry) {
			registry.registerCustomEditor(LoanAmountDetails.class, new LoanAmountDetailsEditor());	
		}
	} //inner class  
	
}
