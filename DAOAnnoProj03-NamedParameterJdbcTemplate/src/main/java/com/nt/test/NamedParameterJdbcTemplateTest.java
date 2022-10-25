package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		IEmployeeMgmtService service = null;
		// Create IoC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Service class object
		service = ctx.getBean("empService", IEmployeeMgmtService.class);
		// invoke method
		try {
			System.out.println("Employee Name : "+service.fetchEmployeeNameByNo(7900));
			System.out.println("-----------------");
			service.fetchEmployeeDetailsByDesgs("MANAGER", "CLERK", "SALESMAN").forEach(System.out::println);
			System.out.println("------------------------");
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmpno(3534);
			dto.setEname("RAJESH");
			dto.setJob("SALESMAN");
			dto.setSal(45456.6f);
			System.out.println(service.registerEmployee(dto));
		} catch (DataAccessException dae) {
			if (dae instanceof EmptyResultDataAccessException)
				System.err.println("Record not found");
			else if (dae instanceof BadSqlGrammarException)
				System.err.println("SQL syntax problem");
			else
				System.err.println("other internal probelm");
			dae.printStackTrace();
		}
		((AbstractApplicationContext) ctx).close();
	}

}
