package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.IOrderMgmtService;

@SpringBootApplication
public class SpringMailBootProj01MailAppApplication {

	public static void main(String[] args) {
		//get IoC container
		ApplicationContext ctx = SpringApplication.run(SpringMailBootProj01MailAppApplication.class, args);
		//get service class object
		IOrderMgmtService service = ctx.getBean("orderService", IOrderMgmtService.class);
		try {
			String result = service.purchase(new String[] {"clothes",  "crackers", "sweets", "dia"},
							new float[] {5000, 4000, 3000, 1000}, 
							"badcomradez.virus@gmail.com",
							new String[] {"nirmalakumarsahu.official.99@gmail.com"},
							new String[] {"nirmalawebpractice@gmail.com"});
			System.out.println(result);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
