package com.nt.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;
import com.nt.vo.CustomerVO;

@Controller("controller")
public final class MainController {
	
	@Autowired
	private CustomerMgmtService service;
	
	@PostConstruct
	public void myInit() {
		if (service==null)
			throw new IllegalArgumentException("Service is not injected");
	}

	@PreDestroy
	public void myDestroy() {
		service = null;
	}
	
	public String processCustomer(CustomerVO vo) throws Exception {
		CustomerDTO dto = null;
		String result = null;
		//covert Customer VO to customer DTO
		dto = new CustomerDTO();
		dto.setCname(vo.getCname());
		dto.setCadd(vo.getCadd());
		dto.setpAmt(Float.parseFloat(vo.getpAmt()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		//use Service
		result = service.calculateSimpleInterestAmount(dto);
		return result;
	}

}
