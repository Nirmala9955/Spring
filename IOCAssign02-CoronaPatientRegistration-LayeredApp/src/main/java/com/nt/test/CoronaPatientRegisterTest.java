package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.CoronaPatientVO;

public class CoronaPatientRegisterTest {

	public static void main(String[] args) {
		Scanner sc = null;
		String name=null, address=null, age=null, hospital=null, days=null;
		CoronaPatientVO vo = null;
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		MainController controller = null;
		String result = null;
		//Get Scanner class object
		sc = new Scanner(System.in);
		//read input from End-user
		System.out.println("Enter the following details to get the hospital bill : ");
		System.out.print("Enter Patient Name : ");
		name = sc.next();
		System.out.print("Enter Patient Address : ");
		address = sc.next();
		System.out.print("Enter Patient Age : ");
		age = sc.next();
		System.out.print("Enter Hospital Name : ");
		hospital = sc.next();
		System.out.print("Enter No of Days : ");
		days = sc.next();
		//Store in VO class object
		vo = new CoronaPatientVO();
		vo.setPatientName(name);
		vo.setPatientAddress(address);
		vo.setPatientAge(age);
		vo.setHospitalName(hospital);
		vo.setNoOfDays(days);
		//Create Bean Factory IoC container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get controller class object
		controller = factory.getBean("controller", MainController.class);
		//invoke method
		try {
			result = controller.coronaPatientRegistration(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal problem");
			e.printStackTrace();
		}
	}

}
