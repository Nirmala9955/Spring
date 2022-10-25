package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;

@Service("custService")
@Profile({"dev", "test"})
public final class MySQLCustomerMgmtServiceImpl implements CustomerMgmtService {
	
	@Autowired
	@Qualifier("mysqlCustDAO")
	private CustomerDAO dao;

	@Override
	public String calculateSimpleInterestAmount(CustomerDTO dto) throws Exception {
		float interAmt = 0.f;
		CustomerBO bo = null;
		int count = 0;
		//Calculate the simple interest amount from DTO
		interAmt = (dto.getPAmt()*dto.getTime()*dto.getRate())/100;
		//Prepare CustomerBO having persist able Data
		bo = new CustomerBO();
		bo.setCname(dto.getCname());
		bo.setCadd(dto.getCadd());
		bo.setPAmnt(dto.getPAmt());
		bo.setInterAmt(interAmt);
		//use the dao
		count = dao.insert(bo);
		if (count==0) 
			return "Customer registration failed - Insert amount is : "+interAmt;
		else
			return "Customer registration succeded - Insert amount is : "+interAmt; 
	}

}
