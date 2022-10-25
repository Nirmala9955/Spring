package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	@Autowired
	public EmployeeDAO dao;
	
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