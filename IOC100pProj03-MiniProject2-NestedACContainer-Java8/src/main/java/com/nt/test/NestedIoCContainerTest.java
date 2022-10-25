package com.nt.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.BusinessAppConfig;
import com.nt.config.PresentationAppConfig;
import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class NestedIoCContainerTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext parentCtx = null, childCtx = null;
		MainController controller = null;
		List<EmployeeVO> listVO = null;
		//create the parent IoC container 
		parentCtx = new AnnotationConfigApplicationContext(BusinessAppConfig.class);
		//create child  IoC container
		childCtx = new AnnotationConfigApplicationContext(PresentationAppConfig.class);
		childCtx.setParent(parentCtx);
		
		//create child  IoC container
		childCtx = new AnnotationConfigApplicationContext();
		childCtx.setParent(parentCtx);
		childCtx.register(PresentationAppConfig.class);
		childCtx.refresh();
		
		//get controller object
		controller = childCtx.getBean("controller", MainController.class);
		//invoke the method
		try {
			listVO = controller.getEmployeeByDesg("clerk", "manager", "salesman");
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
