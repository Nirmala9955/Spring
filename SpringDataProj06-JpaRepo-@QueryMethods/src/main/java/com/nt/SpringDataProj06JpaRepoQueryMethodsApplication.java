package com.nt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@SpringBootApplication
public class SpringDataProj06JpaRepoQueryMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerRepo custRepo = null;
		// get AC IoC container
		ctx = SpringApplication.run(SpringDataProj06JpaRepoQueryMethodsApplication.class, args);
		// Get Repo bean
		custRepo = ctx.getBean(CustomerRepo.class);
		// invoke the methods
		/*	custRepo.getAllCustomers().forEach(System.out::println);
			custRepo.getCustomerByCity("hyd").forEach(System.out::println);
			custRepo.getCustomerByCity("hyd").forEach(System.out::println);
			custRepo.getCustomerByBillAmountRange(200000, 400000).forEach(System.out::println);*/
		// custRepo.getCustomerByCityNames("hyd", "vizg",
		// "delih").forEach(System.out::println);
		// custRepo.getCustomerByName("hari").forEach(System.out::println);
		// custRepo.getCustomerByCnoRange(1, 2).forEach(System.out::println);

		/*System.out.println(custRepo.getCustomerByName("hari"));
		List<Object[]> list = custRepo.getDataValueByName("hari");
		Object value[] = list.get(0);
		System.out.println(value[0]+" "+value[1]);
		Object obj[] = (Object[]) custRepo.getDataValueByName("hari");
		System.out.println(obj[0]+" "+obj[1]);
		System.out.println(custRepo.getBillAmountByName("hari"));
		System.out.println("Max Bill amount is :"+custRepo.findMaxBillAmount());
		Object result[] = (Object[]) custRepo.findAggregateResults();
		System.out.println("Max : "+result[0]);
		System.out.println("Sum : "+result[1]);
		System.out.println("Avg : "+result[2]);
		System.out.println("Count : "+result[3]);
		
		System.out.println("Number of records are updated : "+custRepo.modifyCustomeByCity("hyd", 100));
		System.out.println("Number of records are deleted : "+custRepo.deleteCustomeIfCadIsNull());*/
		
		/*		custRepo.getCustomersByAddress("hyd").forEach(System.out::println);
				System.out.println(custRepo.getSystemDate());
				int count = custRepo.insertCustomer(234.3, "katu", "kalia");
				System.out.println(count==0?"Record is not inserted":"Record is inserted");*/
		
		//call PL/SQL procedure
		//custRepo.featchCustomerDataByAddrs("hyd").forEach(System.out::println);
		
		//calling PL/SQL procedure having Entity query with In param using EntityManager
		EntityManager manager = ctx.getBean(EntityManager.class);
		//create StoreProcedureQuery object
		StoredProcedureQuery procedure = manager.createStoredProcedureQuery("GET_CUSTOMERS_BY_ADDS",  Customer.class);
		procedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		//set Value to In param
		procedure.setParameter(1, "hyd");
		//call Pl/SQL procedure
		procedure.getResultList().forEach(System.out::println);
		//close  EntityManager
		manager.close();
		
		// close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
