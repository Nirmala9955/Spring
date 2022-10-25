package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	public EmployeeDAO dao;
	public String type;
	
	public EmployeeMgmtServiceImpl(EmployeeDAO dao, String type) {
		System.out.println("Type : "+type);
		this.dao = dao;
		this.type =  type;
	}
	
	@Override
	public String toString() {
		return "EmployeeMgmtServiceImpl [type=" + type + "]";
	}

	@Override
	public List<EmployeeDTO> fetchEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<EmployeeBO> listBO = null;
		List<EmployeeDTO> listDTO = new ArrayList<>();
		//Covert desg into upper case
		desg1 = desg1.toUpperCase();
		desg2 = desg2.toUpperCase();
		desg3 = desg3.toUpperCase();
		//use DAO
		listBO = dao.getEmployeesByDesgs(desg1, desg2, desg3);
		listBO.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSal((float) Math.round(bo.getSal()));
			dto.setSerialNo(listDTO.size()+1);
			//add each dto to listDTO
			listDTO.add(dto);
		});
		return listDTO;
	}
	
}