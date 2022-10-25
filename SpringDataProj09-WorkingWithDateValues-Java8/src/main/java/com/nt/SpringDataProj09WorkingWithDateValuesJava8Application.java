package com.nt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.EmployeeInfoDTO;
import com.nt.service.EmployeeInfoMgmtService;

@SpringBootApplication
public class SpringDataProj09WorkingWithDateValuesJava8Application {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EmployeeInfoMgmtService service = null;
		EmployeeInfoDTO dto = null;
		//create Container
		ctx = SpringApplication.run(SpringDataProj09WorkingWithDateValuesJava8Application.class, args);
		//get Service object
		service = ctx.getBean("empService", EmployeeInfoMgmtService.class);
		//invoke the method
		try {
			//pepare DTO 
			dto = new EmployeeInfoDTO();
			dto.setEname("Harish");
			dto.setEadd("hyd");
			dto.setDob(LocalDateTime.of(1990, 03, 26, 12, 35, 05));
			dto.setDoj(LocalDate.of(2015, 07, 23));
			dto.setBatchTime(LocalTime.now());
			
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
