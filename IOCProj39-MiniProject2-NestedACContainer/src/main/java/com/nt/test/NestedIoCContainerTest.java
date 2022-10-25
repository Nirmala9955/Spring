package com.nt.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class NestedIoCContainerTest {

	public static void main(String[] args) {
		ApplicationContext parentCtx = null, childCtx = null;
		MainController controller = null;
		Scanner sc = null;
		String desg1=null, desg2=null, desg3=null;
		List<EmployeeVO> listVO = null;
		//create the parent ioc container 
		parentCtx = new ClassPathXmlApplicationContext("com/nt/cfgs/business-beans.xml");
		//create child  IoC container
		childCtx = new ClassPathXmlApplicationContext(new String[] {"com/nt/cfgs/presentation-beans.xml"}, parentCtx);
		//get controller object
		controller = childCtx.getBean("controller", MainController.class);
		//get system object
		sc = new Scanner(System.in);
		System.out.println("Enter the Desginations");
		System.out.print("Enter the Desgination 1 : ");
		desg1 = sc.next();
		System.out.print("Enter the Desgination 2 : ");
		desg2 = sc.next();
		System.out.print("Enter the Desgination 3 : ");
		desg3 = sc.next();
		//invoke the method
		try {
			System.out.println("\nAccording to the give desgination we get the following records\n");
			listVO = controller.getEmployeeByDesg(desg1, desg2, desg3);
			for (EmployeeVO vo : listVO) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//close containers
		((AbstractApplicationContext) parentCtx).close();
		((AbstractApplicationContext) childCtx).close();
	}

}
