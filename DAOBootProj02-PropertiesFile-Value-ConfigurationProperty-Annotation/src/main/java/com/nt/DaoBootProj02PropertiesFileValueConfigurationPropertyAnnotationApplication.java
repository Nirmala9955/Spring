package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.model.Person;

@SpringBootApplication
public class DaoBootProj02PropertiesFileValueConfigurationPropertyAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		//get IoC container
		ctx = SpringApplication.run(DaoBootProj02PropertiesFileValueConfigurationPropertyAnnotationApplication.class, args);
		//get Spring bean object
		Person pers = ctx.getBean("per", Person.class);
		System.out.println(pers);
	}

}
