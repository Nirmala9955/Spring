package com.nt.contoller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.vo.EmployeeVO;

public class MainController {
	
	private EmployeeMgmtService service;

	public MainController(EmployeeMgmtService service) {
		this.service = service;
	}
	
	public String employeeRegistration(EmployeeVO vo) throws Exception {
		EmployeeDTO dto = null;
		String result = null;
		//Convert VO to DTO
		dto = new EmployeeDTO();
		dto.setEmpName(vo.getEmpName());
		dto.setEmpAddress(vo.getEmpAddress());
		dto.setDesg(vo.getDesg());
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		//use Service 
		result = service.calculatNetGrossSalary(dto);
		return result;
	}
}
