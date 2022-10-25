package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.IEmployeeMgmtService;

@SpringBootApplication
public class DaoBootProj01JdbcTemplateDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		IEmployeeMgmtService service = null;
		//get IoC container
		ctx = SpringApplication.run(DaoBootProj01JdbcTemplateDirectMethodsApplication.class, args);
		//get service class object
		service = ctx.getBean("empService", IEmployeeMgmtService.class);
		//invoke methods
		try { 
			System.out.println("Employees count:"+service.fetchEmpsCount());
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
	}

}
