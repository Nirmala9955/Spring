package com.nt.service;

import com.nt.dto.EmployeeInfoDTO;

public interface EmployeeInfoMgmtService {

	public Integer registerEmployee(EmployeeInfoDTO dto);
	Iterable<EmployeeInfoDTO> getAllEmployeeInformation();

}
