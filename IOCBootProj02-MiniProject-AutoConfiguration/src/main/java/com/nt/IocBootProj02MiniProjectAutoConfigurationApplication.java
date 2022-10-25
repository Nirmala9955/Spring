package com.nt;

import java.util.Scanner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
public class IocBootProj02MiniProjectAutoConfigurationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		MainController controller  = null;
		String name=null, address=null, Amount=null, time=null, rate=null;
		CustomerVO vo = null;
		String result = null;
		Scanner sc = null;
		//Read inputs from end-user using scanner
		sc = new Scanner(System.in);
		System.out.println("Enter the following Details for registration : ");
		System.out.print("Enter Customer Name : ");
		name = sc.next();
		System.out.print("Enter Customer Address : ");
		address = sc.next();
		System.out.print("Enter Customer Principle Amount : ");
		Amount = sc.next();
		System.out.print("Enter Customer Time : ");
		time = sc.next();
		System.out.print("Enter Customer Rate of Interest: ");
		rate = sc.next();
		//Store into VO class object
		vo = new CustomerVO();
		vo.setCname(name);
		vo.setCadd(address);
		vo.setpAmt(Amount);
		vo.setTime(time);
		vo.setRate(rate);
		//get controller class object
		//get container
		SpringApplication app  = new SpringApplication();
		app.setBannerMode(Banner.Mode.OFF);
		ctx = app.run(IocBootProj02MiniProjectAutoConfigurationApplication.class, args);
		//get controller class
		controller = ctx.getBean("controller", MainController.class);
		//invoke mmethods
		try {
			result = controller.processCustomer(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal probelm : "+e.getMessage());
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
