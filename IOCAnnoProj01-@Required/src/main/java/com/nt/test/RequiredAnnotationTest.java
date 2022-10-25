package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.PersonInfo;

public class RequiredAnnotationTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		PersonInfo pinfo = null; 
		// Create AC IoC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get PersonInfo object
		pinfo = ctx.getBean("personInfo", PersonInfo.class);
		System.out.println(pinfo);
		
		((AbstractApplicationContext) ctx).close();
	}

}
