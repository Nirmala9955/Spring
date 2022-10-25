package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealTimeDITest {

	public static void main(String[] args) {
		Scanner sc = null;
		String name=null, address=null, Amount=null, time=null, rate=null;
		CustomerVO vo = null;
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		MainController controller = null;
		String result = null;
		//Read inputs from end-user using scanner
		sc = new Scanner(System.in);
		System.out.println("Enter the following Details for registration : ");
		System.out.print("Enter Customer Name : ");
		name = sc.next();
		System.out.print("Enter Customer Address : ");
		address = sc.next();
		System.out.print("Enter Customer Principle Amount : ");
		Amount = sc.next();
		System.out.print("Enter Customer Time : ");
		time = sc.next();
		System.out.print("Enter Customer Rate of Interest: ");
		rate = sc.next();
		//Store into VO class object
		vo = new CustomerVO();
		vo.setCname(name);
		vo.setCadd(address);
		vo.setpAmt(Amount);
		vo.setTime(time);
		vo.setRate(rate);
		//Create BeanFactory [IoC] container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get controller class object
		controller = factory.getBean("controller", MainController.class);
		//invoke mmethods
		try {
			result = controller.processCustomer(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal probelm : "+e.getMessage());
			e.printStackTrace();
		}
	} //main

} //class
