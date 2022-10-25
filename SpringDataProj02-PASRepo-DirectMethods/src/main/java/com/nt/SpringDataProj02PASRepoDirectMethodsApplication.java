package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataProj02PASRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerMgmtService service = null;
		//get AC IoC container 
		ctx = SpringApplication.run(SpringDataProj02PASRepoDirectMethodsApplication.class, args);
		//get service class object
		service = ctx.getBean("custService", CustomerMgmtService.class);
		//invoke method
		//service.fetchAllRecordsSortByProprty(true, "cname").forEach(System.out::println);
		System.out.println("---------------------------");
		//service.fetchAllRecordsSortByProprties(true, "cname", "cadd").forEach(System.out::println);		
		System.out.println("---------------------------");
		//service.fetchRecordsByPageNoAndSize(0, 3).forEach(System.out::println);
			System.out.println("----------------------------");
			service.fetchRecordByPagination(3);
		
		//close container 
		((ConfigurableApplicationContext) ctx).close();
	}

}
