package com.nt.service;

import java.util.List;

import com.nt.dto.CoronaPatientDTO;

public interface CoronaPatientMgmtService {
	public List<CoronaPatientDTO> fetchCoronaPatientsByDist(String dist) throws Exception;
}
