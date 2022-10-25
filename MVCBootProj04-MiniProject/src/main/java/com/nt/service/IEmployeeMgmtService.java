package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	public List<EmployeeDTO> fetchAllEmployees();
	public String registerEmployee(EmployeeDTO dto);
	public List<Integer> fetchALLDeptNo();
	public String removeEmployeeById(int id);
	public EmployeeDTO fetchEmployeeById(int id);
	public String ModifyEmployeeById(EmployeeDTO dto);
}
