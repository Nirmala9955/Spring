package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataAssignj01CurdRepoDeleteMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerMgmtService service = null;
		//get AC IoC container 
		ctx = SpringApplication.run(SpringDataAssignj01CurdRepoDeleteMethodsApplication.class, args);
		//get service class object
		service = ctx.getBean("custService", CustomerMgmtService.class);
		System.out.println(service.removeAllCustomer());
		
		//close container 
		((ConfigurableApplicationContext) ctx).close();
	}

}
