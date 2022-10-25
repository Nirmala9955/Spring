package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.nt.service.ILoginMgmtService;

public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ILoginMgmtService service = null;
		// Create IoC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Service class object
		service = ctx.getBean("loginService", ILoginMgmtService.class);
		// invoke method
		try {
			System.out.println(service.login("nimu", "nimu@123"));
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
