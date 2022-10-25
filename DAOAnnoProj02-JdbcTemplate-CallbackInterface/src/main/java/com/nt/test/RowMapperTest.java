package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.nt.dto.StudentDTO;
import com.nt.service.IStudentMgmtService;

public class RowMapperTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		IStudentMgmtService service = null;
		StudentDTO dto = null;
		// Create Container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service = ctx.getBean("studService", IStudentMgmtService.class);
		//invoke method
		try {
			/*dto = service.fetchStudentById(102);
			System.out.println(dto);*/
			//List<StudentDTO> listDTO = service.fetchStudentsByCities("hyd", "vizg", "delhi");
			List<StudentDTO> listDTO = service.fetchStudentsByCities("hyd", "vizg", "delhi");
			listDTO.forEach(System.out::println);
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
