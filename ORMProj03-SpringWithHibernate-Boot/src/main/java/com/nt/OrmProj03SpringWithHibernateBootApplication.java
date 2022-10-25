package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.ProjectDTO;
import com.nt.service.ProjectMgmtService;

@SpringBootApplication
public class OrmProj03SpringWithHibernateBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ProjectMgmtService service= null;
		ProjectDTO dto = null;
		List<ProjectDTO> listDTO = null;
		//Create AC IoC container
		ctx = SpringApplication.run(OrmProj03SpringWithHibernateBootApplication.class, args);
		// get Service class obejct
		service = ctx.getBean("projService", ProjectMgmtService.class);
		try {
			// Create DTO
			dto = new ProjectDTO();
			dto.setProjName("BwSE23");
			dto.setTeamSize(23);
			dto.setCompany("NimuSo2ft2.com");
			dto.setLocation("Odisha");
			dto.setCost(400000.0);
			// use service
			System.out.println(service.registerProject(dto));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		/*
		 * System.out.println("-------------------");
		 * System.out.println("Project details : "+service.fetchProjectById(1));
		 * System.out.println("-------------------");
		 * System.out.println("Project update : "+service.modifyProjectById(1, 23,
		 * 2435465)); System.out.println("-------------------");
		 * System.out.println("Project delete : "+service.removeProjectById(3));
		 */
		System.out.println("-------------------");
		System.out.print("Projet details by cost range : ");
		listDTO = service.fetchProjectByCostRange(100000, 500000);
		listDTO.forEach(dto1 -> {
			System.out.println(dto1);
		});
		System.out.println("--------------------");
		listDTO.forEach(System.out::println);
		System.out.println("-------------------");
		System.out.println(listDTO);
		System.out.println("-------------------");
		listDTO.stream().forEach(System.out::println);
		((AbstractApplicationContext) ctx).close();
	}

}
