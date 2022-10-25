package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.PersonInfo;

public class PropertyEditorTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		PersonInfo info = null;
		//Create IoC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		info = ctx.getBean("pinfo", PersonInfo.class);
		System.out.println(info);
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
