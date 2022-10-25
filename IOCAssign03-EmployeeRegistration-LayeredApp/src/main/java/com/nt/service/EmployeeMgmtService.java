package com.nt.service;

import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	public String calculatNetGrossSalary(EmployeeDTO dto) throws Exception;
}
