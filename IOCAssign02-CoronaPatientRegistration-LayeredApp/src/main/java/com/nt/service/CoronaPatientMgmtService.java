package com.nt.service;

import com.nt.dto.CoronaPatientDTO;

public interface CoronaPatientMgmtService {
	public String calculatHospitalBillAmount(CoronaPatientDTO dto) throws Exception;
}
