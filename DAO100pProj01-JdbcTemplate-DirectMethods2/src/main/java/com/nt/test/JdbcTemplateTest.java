package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.service.IEmployeeMgmtService;

public class JdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		IEmployeeMgmtService service = null;
		//create IoC container
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//get service class object
		service = ctx.getBean("empService", IEmployeeMgmtService.class);
		//invoke method
		try {
			System.out.println("Employee count is : "+service.fetchEmpsCount());
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
			System.out.println("--------------------------");
			try {
				System.out.println("7499 Employee Name is : "+service.fetchEmployeeNameByNo(7499));
			} catch (DataAccessException dae) {
				dae.printStackTrace();
			}
			System.out.println("--------------------------");
			try {
				System.out.println("7499 Employee Name is : "+service.fetchEmployeeDetailsByNo(7499));
			} catch (DataAccessException dae) {
				dae.printStackTrace();
			}
			System.out.println("--------------------------");
			try {
				//System.out.println("CLERK, MANAGER Employee Details : "+service.fetchEmployeesDetailsByDesg("CLERK", "MANAGER"));
				service.fetchEmployeesDetailsByDesg("CLERK", "MANAGER").forEach(System.out::println);
				
			} catch (DataAccessException dae) {
				dae.printStackTrace();
			}
			System.out.println("--------------------------");
			try {
				System.out.println(service.resgisteEmployee("SYAM", "MANAGER", 45000));
			} catch (DataAccessException dae) {
				dae.printStackTrace();
			}
			System.out.println("--------------------------");
			try {
				System.out.println(service.putBonusToEmployeeByDesg("MANAGER", 1000));
			} catch (DataAccessException dae) {
				dae.printStackTrace();
			}
		((AbstractApplicationContext) ctx).close();
	}
	
}
