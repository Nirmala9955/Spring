package com.nt.controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;
import com.nt.vo.CustomerVO;

public final class MainController {
	
	private CustomerMgmtService service;

	public MainController(CustomerMgmtService service) {
		this.service = service;
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
