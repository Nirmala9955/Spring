package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/welcome")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/list_emps")
	public String showEmployee(Map<String, Object> map) {
		List<EmployeeDTO> listDTO = null;
		//use service
		listDTO = service.fetchAllEmployees();
		//keep result in model attribute
		map.put("empsInfo", listDTO);
		return "show_report";
	}
}
