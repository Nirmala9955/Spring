package com.nt.service;

import java.util.List;

import com.nt.dto.CricketerDTO;

public interface CricketerMgmtService {
	public List<CricketerDTO> fetchCricketersByRole(String role) throws Exception;
}
