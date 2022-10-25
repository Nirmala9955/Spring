package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomerRepo;

@SpringBootApplication
public class SpringDataProj04JpaRepoFinderMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerRepo custRepo = null;
		//get AC IoC container 
		ctx = SpringApplication.run(SpringDataProj04JpaRepoFinderMethodsApplication.class, args);
		//Get Repo bean 
		custRepo = ctx.getBean(CustomerRepo.class);
		//invoke the methods
		custRepo.findByCadd("hyd").forEach(System.out::println);
		custRepo.findByCname("Raja").forEach(System.out::println);
		custRepo.findByBillAmountGreaterThan(3000).forEach(System.out::println);
		custRepo.findByBillAmountLessThan(2000).forEach(System.out::println);
		custRepo.findByCnameLike("raj%").forEach(System.out::println);
		custRepo.findByCnameStartingWith("r").forEach(System.out::println);
		custRepo.findByCnameEndingWith("h").forEach(System.out::println);
		custRepo.findByCnameContaining("raj").forEach(System.out::println);
		custRepo.findByCaddIsNull().forEach(System.out::println);
		custRepo.findByCaddIsNotNull().forEach(System.out::println);
		System.out.println("--------------------------");
		custRepo.findByCnameLike("___").forEach(System.out::println);
		custRepo.findByCaddLike("___%").forEach(System.out::println);
		custRepo.findByBillAmountGreaterThanAndBillAmountLessThan(4000, 5000).forEach(System.out::println);
		custRepo.findByBillAmountBetween(4000, 5000).forEach(System.out::println);
		custRepo.findByCnameEqualsOrCaddEquals("raja", "hyd").forEach(System.out::println);
		custRepo.findByBillAmountBetweenOrderByCnameDesc(4000, 5000).forEach(System.out::println);
		//custRepo.findByCaddIn(List.of("hyd", "vizg", "delhi")).forEach(System.out::println);
		//close container 
		((ConfigurableApplicationContext) ctx).close();
	}

}
