package com.nt.service;

import com.nt.bo.CoronaPatientBO;
import com.nt.dao.CoronaPatientDAO;
import com.nt.dto.CoronaPatientDTO;

public class CoronaPatientMgmtServiceImpl implements CoronaPatientMgmtService {
	
	private CoronaPatientDAO  dao;

	public CoronaPatientMgmtServiceImpl(CoronaPatientDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public String calculatHospitalBillAmount(CoronaPatientDTO dto) throws Exception {
		float billAmount = 0;
		CoronaPatientBO bo = null;
		int count = 0;
		//Calculate hospital total bill amount
		billAmount = dto.getNoOfDays()*1000;
		//Perpare BO class object
		bo = new CoronaPatientBO();
		bo.setPatientName(dto.getPatientName());
		bo.setPatientAddress(dto.getPatientAddress());
		bo.setPatientAge(dto.getPatientAge());
		bo.setHospitalName(dto.getHospitalName());
		bo.setNoOfDays(dto.getNoOfDays());
		bo.setBillAmount(billAmount);
		//use DAO
		count = dao.insert(bo);
		if (count==0) 
			return "Corona patient registration failed, try again!";
		else
			return "Corona patient registration succeded and your hospital total bill amount is : "+billAmount;
	}

}
