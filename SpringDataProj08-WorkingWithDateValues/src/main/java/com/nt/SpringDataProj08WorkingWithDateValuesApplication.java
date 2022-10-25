package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.EmployeeInfoDTO;
import com.nt.service.EmployeeInfoMgmtService;

@SpringBootApplication
public class SpringDataProj08WorkingWithDateValuesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EmployeeInfoMgmtService service = null;
		EmployeeInfoDTO dto = null;
		//create Container
		ctx = SpringApplication.run(SpringDataProj08WorkingWithDateValuesApplication.class, args);
		//get Service object
		service = ctx.getBean("empService", EmployeeInfoMgmtService.class);
		//invoke the method
		try {
			//pepare DTO 
			dto = new EmployeeInfoDTO();
			dto.setEname("Harish");
			dto.setEadd("hyd");
			dto.setDob(new Date(90, 04, 06, 12, 35, 05));
			dto.setDoj(new Date(114, 07, 23));
			dto.setBatchTime(new Date());
			
			System.out.println("Register Employee Id : "+service.registerEmployee(dto));
		} catch (Exception e) {
			System.out.println("Problem in Employee Registration");
			e.printStackTrace();
		}
		System.out.println("-------------------");
		service.getAllEmployeeInformation().forEach(System.out::println);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
