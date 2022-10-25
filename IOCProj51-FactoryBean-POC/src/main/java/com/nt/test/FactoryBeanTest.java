package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.ScheduleReminder;

public class FactoryBeanTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ScheduleReminder sReminder = null;
		//Create IOC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get SchedularReminder class object
		sReminder = ctx.getBean("reminder", ScheduleReminder.class);
		//invoke method
		System.out.println(sReminder.checkReminder());
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
