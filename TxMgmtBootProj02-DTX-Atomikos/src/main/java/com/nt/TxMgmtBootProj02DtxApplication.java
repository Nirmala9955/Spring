package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.service.IBankMgmtService;

@SpringBootApplication
public class TxMgmtBootProj02DtxApplication {

	public static void main(String[] args) {
		//create container
		ApplicationContext ctx = SpringApplication.run(TxMgmtBootProj02DtxApplication.class, args);
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
