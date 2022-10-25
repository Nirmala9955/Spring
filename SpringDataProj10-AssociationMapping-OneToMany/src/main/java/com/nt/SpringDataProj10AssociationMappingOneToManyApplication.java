package com.nt;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.PhoneNumberDTO;
import com.nt.dto.UserDTO;
import com.nt.service.TeleCommMgmtService;

@SpringBootApplication
public class SpringDataProj10AssociationMappingOneToManyApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		TeleCommMgmtService service = null;
		PhoneNumberDTO phDTO1 = null, phDTO2 = null;
		UserDTO userDTO = null;
		///create container
		ctx = SpringApplication.run(SpringDataProj10AssociationMappingOneToManyApplication.class, args);
		//get Service class object
		service =ctx.getBean("teleComService",TeleCommMgmtService.class);
		//child object
		phDTO1 = new PhoneNumberDTO();
		phDTO1.setMobileNo(8018149478L);
		phDTO1.setType("residence");
		phDTO1.setProvider("airtel");

		phDTO2 = new PhoneNumberDTO();
		phDTO2.setMobileNo(9337043730L);
		phDTO2.setType("Personal");
		phDTO2.setProvider("jio");
		
		//parent Object
		userDTO = new UserDTO();
		userDTO.setUserName("Harish");
		userDTO.setAddress("UP");
		userDTO.setPhones(Set.of(phDTO1, phDTO2));
		//invoke the method
		try {
			System.out.println(service.registerCustomer(userDTO));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
	}

}
