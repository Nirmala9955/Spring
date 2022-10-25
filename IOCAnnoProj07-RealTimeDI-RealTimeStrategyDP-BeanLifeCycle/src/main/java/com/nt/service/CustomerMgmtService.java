package com.nt.service;

import com.nt.dto.CustomerDTO;

public interface CustomerMgmtService {
	public String calculateSimpleInterestAmount(CustomerDTO dto) throws Exception;
}
