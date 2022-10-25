package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Employee;

public class PAndCNameSpaceTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Employee employee = null;
		//create AC IoC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Employee object or bean
		employee = ctx.getBean("emp", Employee.class);
		System.out.println(employee);
		((AbstractApplicationContext) ctx).close();
	}
	
}
