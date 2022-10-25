package com.nt;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataProj01CurdRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerMgmtService service = null;
		CustomerDTO custDTO = null, custDTO1 = null, custDTO2 = null;
		//get AC IoC container 
		ctx = SpringApplication.run(SpringDataProj01CurdRepoDirectMethodsApplication.class, args);
		//get service class object
		service = ctx.getBean("custService", CustomerMgmtService.class);
		//invoke method
		/*try {
			//prepare DTO object
			custDTO = new CustomerDTO();
			custDTO.setCname("Hari");
			custDTO.setCadd("hyd");
			custDTO.setBillAmount(1000.0);
			System.out.println(service.registerCustomer(custDTO));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("------------------------------");
		custDTO = new CustomerDTO();
		custDTO.setCname("Hari"); custDTO.setCadd("hyd"); custDTO.setBillAmount(1000.0);
		custDTO1 = new CustomerDTO();
		custDTO1.setCname("Ravi"); custDTO1.setCadd("hyd"); custDTO1.setBillAmount(1000.0);
		custDTO2 = new CustomerDTO();
		custDTO2.setCname("javi"); custDTO2.setCadd("hyd"); custDTO2.setBillAmount(1000.0);
		try {
			System.out.println(service.registerGroupCustomer(Arrays.asList(custDTO, custDTO1, custDTO2)));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		/*System.out.println("------------------");
		//System.out.println(service.removeCustomerByID(27));
		System.out.println("-------------------");
		//System.out.println(service.removeGivenCustomers(Arrays.asList(new CustomerDTO(30), new CustomerDTO(24))));
		System.out.println("-------------------");
		System.out.println(service.fetchCustomerCount());
		System.out.println("-------------------");
		System.out.println(service.fetchAllCustomer());*/
		System.out.println("--------------------------------");
		try {
			Optional<CustomerDTO> opt = service.fetchCustomerById(31);
			if (opt.isPresent() && !opt.isEmpty()) 
				System.out.println(opt.get());
			else 
				System.out.println("Record is not there");
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		//close container 
		((ConfigurableApplicationContext) ctx).close();
	}

}
