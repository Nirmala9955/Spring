package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	public String fetchEmployeeNameByNo(int no);
	public List<EmployeeDTO> fetchEmployeeDetailsByDesgs(String desg1, String desg2, String desg3);
	public String registerEmployee(EmployeeDTO dto);
}
