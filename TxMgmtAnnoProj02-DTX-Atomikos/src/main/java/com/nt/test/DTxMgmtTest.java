package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankMgmtService;

public class DTxMgmtTest {

	public static void main(String[] args) {
		//create container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get service object
		IBankMgmtService service = ctx.getBean("bankService", IBankMgmtService.class);
		//invoke business method
		try {
			System.out.println(service.transferMoney(1001, 1002, 800));	
		}
		catch (Exception e) {
			System.out.println("Money not transfered");
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
