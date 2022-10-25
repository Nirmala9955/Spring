package com.nt.test;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.nt.config.AppConfig;
import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealTimeDITest {

	public static void main(String[] args) {
		Scanner sc = null;
		String name=null, address=null, Amount=null, time=null, rate=null;
		CustomerVO vo = null;
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
		vo.setPAmt(Amount);
		vo.setTime(time);
		vo.setRate(rate);
		//Create BeanFactory [IoC] container
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//get Environment object from IoC container
		ConfigurableEnvironment env = ctx.getEnvironment();
		env.setActiveProfiles("dev");
		ctx.register(AppConfig.class);
		ctx.refresh();
		//get controller class object
		controller = ctx.getBean("controller", MainController.class);
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
