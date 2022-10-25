package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.nt.dto.BankAccountDTO;
import com.nt.service.IBankAccountService;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		IBankAccountService service = null;
		// Create IoC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Service class object
		service = ctx.getBean("accService", IBankAccountService.class);
		// invoke method
		try {
			BankAccountDTO dto = new BankAccountDTO();
			dto.setAccno(6489725l); dto.setHolderName("Ram");
			dto.setBalance(347374f); dto.setStatus("Active");
			System.out.println(service.createBankAccount(dto));
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
