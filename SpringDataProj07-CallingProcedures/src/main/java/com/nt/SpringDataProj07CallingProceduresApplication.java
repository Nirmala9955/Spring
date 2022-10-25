package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomerRepo;
import com.nt.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataProj07CallingProceduresApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerRepo custRepo = null;
		CustomerMgmtService service = null;
		// get AC IoC container
		ctx = SpringApplication.run(SpringDataProj07CallingProceduresApplication.class, args);
		// Get Repo bean
		custRepo = ctx.getBean(CustomerRepo.class);
		/*// invoke the metho
		System.out.println("No of records are : "+custRepo.featchCustomersCountByAddress("hyd"));
		System.out.println("No of records are : "+custRepo.GET_CUSTOMERS_COUNT_BY_ADDRS("vizg"));
		
		//Call IN, OUT param using EntityManagere
		//get EntityManager object
		EntityManager manager = ctx.getBean(EntityManager.class);
		//Create StoreProcedureQuery object
		StoredProcedureQuery procedure = manager.createStoredProcedureQuery("GET_CUSTOMERS_COUNT_BY_ADDRS");
		//register params
		procedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		procedure.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
		//set value to in params
		procedure.setParameter(1, "hyd");
		//get result
		int count = (int) procedure.getOutputParameterValue(2);
		System.out.println("No of records are : "+count);*/

		/*// Call IN, OUT param using EntityManagere (ORACLE)
		// get EntityManager object
		EntityManager manager = ctx.getBean(EntityManager.class);
		// Create StoreProcedureQuery object
		StoredProcedureQuery query = manager.createStoredProcedureQuery("GET_CUSTOMERS_DETAILS_BY_ADDRS", Customer.class);
		// register params
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Class.class, ParameterMode.REF_CURSOR);
		// set value to in params
		query.setParameter(1, "hyd");
		// get result
		List<Customer> list = query.getResultList();
		list.forEach(System.out::println);*/

		/*// Call IN, OUT param using EntityManagere (ORACLE SPECIFIC COLUMN)
		// get EntityManager object
		EntityManager manager = ctx.getBean(EntityManager.class);
		// Create StoreProcedureQuery object
		StoredProcedureQuery query = manager.createStoredProcedureQuery("FEATCH_CUSTOMER_DEATILS_BY_ADD");
		// register params
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Class.class, ParameterMode.REF_CURSOR);
		// set value to in params
		query.setParameter(1, "hyd");
		// get result
		List<Object[]> list = query.getResultList();
		list.forEach(row-> {
			for (Object obj : row) {
				System.out.print(obj+" ");
			}
			System.out.println();
		});*/

		/*// Call Authentication Procedure using EntityManagere (ORACLE)
		// get EntityManager object
		EntityManager manager = ctx.getBean(EntityManager.class);
		// Create StoreProcedureQuery object
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_AUTHENTICATION");
		// register params
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		// set value to in params
		query.setParameter(1, "nimu");
		query.setParameter(2, "nimu@123");
		// get result
		String result = (String) query.getOutputParameterValue(3);
		System.out.println("Result : " + result);*/
		
		service = ctx.getBean("custService", CustomerMgmtService.class);
		service.getEmployById(7369);

		// close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
