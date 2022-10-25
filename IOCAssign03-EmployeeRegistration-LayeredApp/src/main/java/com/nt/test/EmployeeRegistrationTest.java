package com.nt.test;
import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.contoller.MainController;
import com.nt.vo.EmployeeVO;

public class EmployeeRegistrationTest {

	public static void main(String[] args) {
		Scanner sc = null;
		String name = null, address = null, desg = null, salary=null;
		EmployeeVO vo = null;
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		MainController controller = null;
		String result = null;
		//read inputs form end-user
		sc = new Scanner(System.in);
		System.out.println("Enter Employee Details");
		System.out.print("Enter Employee Name : ");
		name = sc.next();
		System.out.print("Enter Employee Address : ");
		address = sc.next();
		System.out.print("Enter Desgination : ");
		desg = sc.next();
		System.out.print("Enter Basic Salary : ");
		salary = sc.next();
		//Store inputs to VO class object
		vo = new EmployeeVO();
		vo.setEmpName(name);
		vo.setEmpAddress(address);
		vo.setDesg(desg);
		vo.setBasicSalary(salary);
		//Create Bean Factory IoC container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get controller class object
		controller = factory.getBean("controller", MainController.class);
		//invoke method
		try {
			result = controller.employeeRegistration(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal problem");
			e.printStackTrace();
		}
	}

}
