package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.TeleCommMgmtService;

@SpringBootApplication
public class SpringDataProj11JPQLJoinsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		TeleCommMgmtService service = null;
		//create container
		ctx = SpringApplication.run(SpringDataProj11JPQLJoinsApplication.class, args);
		//get Service class object
		service =ctx.getBean("teleComService",TeleCommMgmtService.class);
		service.getDataByJoin().forEach(row->{
			for (Object val: row) 
				System.out.print(val+" ");
			System.out.println();
		});
		System.out.println("-----------------------");
		service.getDataByJoinUsingAddress("MP").forEach(row->{
			for (Object val: row) 
				System.out.print(val+" ");
			System.out.println();
		});
			
	}

}
