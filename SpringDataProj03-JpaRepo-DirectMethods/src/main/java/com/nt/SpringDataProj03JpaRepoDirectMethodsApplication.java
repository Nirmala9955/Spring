package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataProj03JpaRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerMgmtService service = null;
		CustomerDTO dto = null;
		//get AC IoC container 
		ctx = SpringApplication.run(SpringDataProj03JpaRepoDirectMethodsApplication.class, args);
		//get service class object
		service = ctx.getBean("custService", CustomerMgmtService.class);
		//invoke method
		dto = new CustomerDTO();
		dto.setCadd("hyd");
		//service.fetchAllRecordsByGivenExampleDTO(dto).forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println(service.removeAllCustomer());		
		//close container 
		((ConfigurableApplicationContext) ctx).close();
	}

}
