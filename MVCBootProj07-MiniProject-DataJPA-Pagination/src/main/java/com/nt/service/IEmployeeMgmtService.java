package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	public List<EmployeeDTO> fetchAllEmployees();
	public String registerEmployee(EmployeeDTO dto);
	public List<Integer> fetchALLDeptNo();
	public void removeEmployeeById(int id);
	public EmployeeDTO fetchEmployeeById(int id);
	public String ModifyEmployeeById(EmployeeDTO dto);
	
	public Page<EmployeeDTO> getPageData(Pageable pageable);
}
