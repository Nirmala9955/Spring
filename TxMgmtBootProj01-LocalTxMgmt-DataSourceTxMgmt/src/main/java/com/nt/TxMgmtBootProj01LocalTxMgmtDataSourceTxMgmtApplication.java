package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.service.IBankMgmtService;

@SpringBootApplication
public class TxMgmtBootProj01LocalTxMgmtDataSourceTxMgmtApplication {

	public static void main(String[] args) {
		//get Container
		ApplicationContext ctx = SpringApplication.run(TxMgmtBootProj01LocalTxMgmtDataSourceTxMgmtApplication.class, args);
		// get service object
		IBankMgmtService service = ctx.getBean("bankService", IBankMgmtService.class);
		// invoke business method
		try {
			if (service.transferMoney(1001, 1000, 800))
				System.out.println("Money transfered");
			else
				System.out.println("Problem in Money transfered");
		} catch (Exception e) {
			System.out.println("Money not transfered");
			e.printStackTrace();
		}
		// close container
		((AbstractApplicationContext) ctx).close();
	}

}
