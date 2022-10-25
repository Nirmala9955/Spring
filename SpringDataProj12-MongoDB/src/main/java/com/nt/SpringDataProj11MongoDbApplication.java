package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.document.Employee;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
public class SpringDataProj11MongoDbApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EmployeeMgmtService service = null;
		Employee doc1 = null;
		//get Container
		ctx = SpringApplication.run(SpringDataProj11MongoDbApplication.class, args);
		//get Service object
		service = ctx.getBean("empService", EmployeeMgmtService.class);
		//invoke the method
		try {
			doc1 = new Employee();
			doc1.setEid(104); doc1.setEname("yadv");
			doc1.setEadd("delhi"); doc1.setSalary(565674.0);
			doc1.setCompany("Polarish");
			doc1.setOldCompanies(new String[] {"HCL", "DELL", "WIPRO"});
			System.out.println(service.registerEmployee(doc1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("---------------------");
		//service.findAllEmployees().forEach(System.out::println);
		System.out.println("------------------------");
		//System.out.println(service.findEmpById(102));
		System.out.println("------------------------");
		//System.out.println(service.updateEmployeeSalary(102, 1000));
		System.out.println("------------------------");
		System.out.println(service.removeEmployee(103));
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
