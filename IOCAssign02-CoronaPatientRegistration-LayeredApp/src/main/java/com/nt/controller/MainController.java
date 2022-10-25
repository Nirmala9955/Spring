package com.nt.controller;

import com.nt.dto.CoronaPatientDTO;
import com.nt.service.CoronaPatientMgmtService;
import com.nt.vo.CoronaPatientVO;

public class MainController {
	
	private CoronaPatientMgmtService service;

	public MainController(CoronaPatientMgmtService service) {
		this.service = service;
	}
	
	public String coronaPatientRegistration(CoronaPatientVO vo) throws Exception {
		CoronaPatientDTO dto = null;
		String result = null;
		//covert VO TO DTO
		dto = new CoronaPatientDTO();
		dto.setPatientName(vo.getPatientName());
		dto.setPatientAddress(vo.getPatientAddress());
		dto.setPatientAge(Integer.parseInt(vo.getPatientAge()));
		dto.setHospitalName(vo.getHospitalName());
		dto.setNoOfDays(Integer.parseInt(vo.getNoOfDays()));
		//use service
		result = service.calculatHospitalBillAmount(dto);
		return result;
	}
	
	
}
