package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class IocBootProj01DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		WishMessageGenerator generator = null;
		ctx = SpringApplication.run(IocBootProj01DependencyInjectionApplication.class, args);
		//get Bean
		generator = ctx.getBean("wmg", WishMessageGenerator.class);
		//invoke method
		System.out.println(generator.generateWishMessage("nimu"));
		
	}

}
