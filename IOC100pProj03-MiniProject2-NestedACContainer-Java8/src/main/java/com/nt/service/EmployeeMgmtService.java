package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	public List<EmployeeDTO> fetchEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception;
}
