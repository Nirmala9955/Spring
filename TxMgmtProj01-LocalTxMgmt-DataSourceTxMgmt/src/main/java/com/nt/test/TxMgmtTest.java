package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankMgmtService;

public class TxMgmtTest {

	public static void main(String[] args) {
		//create container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get service object
		IBankMgmtService service = ctx.getBean("bankService", IBankMgmtService.class);
		//invoke business method
		try {
			if (service.transferMoney(1003, 1000, 800))
				System.out.println("Money transfered");
			else
				System.out.println("Problem in Money transfered");
		}
		catch (Exception e) {
			System.out.println("Money not transfered");
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
