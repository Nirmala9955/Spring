package com.nt.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;

@Service("custService")
public final class CustomerMgmtServiceImpl implements CustomerMgmtService {
	
	/*@Autowired
	//@Qualifier("oracleCustDAO")
	@Qualifier("mysqlCustDAO")
	private CustomerDAO dao;*/
	
	private CustomerDAO dao;
	
	@PostConstruct
	public void myInit() {
		if (dao==null)
			throw new IllegalArgumentException("DAO is not injected");
	}

	@PreDestroy
	public void myDestroy() {
		dao = null;
	}

	
	@Value("${jdbc.dao}")
	private String value;
	
	@Autowired
	public void setCustomerDAO(ApplicationContext ctx) {
		this.dao = (CustomerDAO) ctx.getBean(value);
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
