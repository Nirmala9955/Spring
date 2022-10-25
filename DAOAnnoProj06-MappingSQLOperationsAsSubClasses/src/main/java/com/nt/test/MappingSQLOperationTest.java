package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.nt.service.IBankMgmtService;

public class MappingSQLOperationTest {

	public static void main(String[] args) {
		// Create IoC container
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Service class object
		IBankMgmtService service = ctx.getBean("bankService", IBankMgmtService.class);
		// invoke method
		try {
			System.out.println("Bank ACcounts having balance Range 10000 to 20000");
			service.fetchBankAccountsByBalanceRange(10000, 20000).forEach(System.out::println);
			System.out.println("--------------------------");
			System.out.println(service.fetchBankAccountsByAccNo(33232));
			System.out.println("---------------------");
			System.out.println(service.addBonusToBankAccountsByBalance(500, 10000));
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
