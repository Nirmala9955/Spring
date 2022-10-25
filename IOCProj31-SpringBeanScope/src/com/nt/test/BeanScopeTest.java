package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.WishMessageGenerator;
import com.nt.sdp.Printer;

public class BeanScopeTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		WishMessageGenerator generator1 = null, generator2 = null, generator3 = null;
		WishMessageGenerator gen1 = null, gen2 = null, gen3 = null;
		Printer  printer1 = null, printer2=null;
		// Create Bean Factory IoC Container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		// create object
		generator1 = factory.getBean("wmg", WishMessageGenerator.class);
		generator2 = factory.getBean("wmg", WishMessageGenerator.class);
		generator3 = factory.getBean("wmg", WishMessageGenerator.class);
		System.out.println(generator1.hashCode() + "..." + generator2.hashCode() + "..." + generator3.hashCode());
		System.out.println("generator1==generator2?" + (generator1 == generator2));
		System.out.println("generator2==generator3?" + (generator2 == generator3));
		System.out.println("generator1==generator3?" + (generator1 == generator3));
		System.out.println("------------------------------------");
		// create object
		gen1 = factory.getBean("wmg1", WishMessageGenerator.class);
		gen2 = factory.getBean("wmg1", WishMessageGenerator.class);
		gen3 = factory.getBean("wmg1", WishMessageGenerator.class);
		System.out.println(gen1.hashCode() + "..." + gen2.hashCode() + "..." + gen3.hashCode());
		System.out.println("gen1==gen2?" + (gen1 == gen2));
		System.out.println("gen2==gen3?" + (gen2 == gen3));
		System.out.println("gen1==gen3?" + (gen1 == gen3));
		System.out.println("--------------------------------------");
		printer1 = factory.getBean("printerBean", Printer.class);
		printer1.printData("Hello");
		printer2 = factory.getBean("printerBean", Printer.class);
		printer2.printData("Hill");
		System.out.println(printer1.hashCode()+"..."+printer2.hashCode());
	}

}
