package com.nt.service;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;

public final class CustomerMgmtServiceImpl implements CustomerMgmtService {
	
	private CustomerDAO dao;

	public CustomerMgmtServiceImpl(CustomerDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public String calculateSimpleInterestAmount(CustomerDTO dto) throws Exception {
		float interAmt = 0.f;
		CustomerBO bo = null;
		int count = 0;
		//Calculate the simple interest amount from DTO
		interAmt = (dto.getpAmt()*dto.getTime()*dto.getRate())/100;
		//Prepare CustomerBO having persist able Data
		bo = new CustomerBO();
		bo.setCname(dto.getCname());
		bo.setCadd(dto.getCadd());
		bo.setpAmnt(dto.getpAmt());
		bo.setInterAmt(interAmt);
		//use the dao
		count = dao.insert(bo);
		if (count==0) 
			return "Customer registration failed - Insert amount is : "+interAmt;
		else
			return "Customer registration succeded - Insert amount is : "+interAmt; 
	}

}
