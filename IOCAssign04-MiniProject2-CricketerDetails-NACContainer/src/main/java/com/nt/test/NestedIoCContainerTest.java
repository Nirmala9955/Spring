package com.nt.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.CricketerVO;

public class NestedIoCContainerTest {

	public static void main(String[] args) {
		ApplicationContext parentCtx = null, childCtx = null;
		MainController controller = null;
		Scanner sc = null;
		String role = null;
		List<CricketerVO> listVO = null;
		//create the parent IoC container 
		parentCtx = new ClassPathXmlApplicationContext("com/nt/cfgs/business-beans.xml");
		//create child  IoC container
		childCtx = new ClassPathXmlApplicationContext(new String[] {"com/nt/cfgs/presentation-beans.xml"}, parentCtx);
		//get controller object
		controller = childCtx.getBean("controller", MainController.class);
		//get system object
		sc = new Scanner(System.in);
		System.out.print("Enter the Role : ");
		role = sc.next();
		//invoke the method
		try {
			System.out.println("\nAccording to the give role you get the following records\n");
			listVO = controller.getCricketersByRole(role);
			/*listVO.forEach(vo->{
				System.out.println(vo);
			});*/
			//listVO.forEach(vo->System.out.println(vo));
			listVO.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//close containers
		((AbstractApplicationContext) parentCtx).close();
		((AbstractApplicationContext) childCtx).close();
	}

}
