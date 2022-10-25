package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.IBankMgmtService;

public class TxMgmtTest {

	public static void main(String[] args) {
		//create container
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//get service object
		IBankMgmtService service = ctx.getBean("bankService", IBankMgmtService.class);
		//invoke business method
		try {
			if (service.transferMoney(1001, 1000, 800))
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
