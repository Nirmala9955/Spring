package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDAO dao;
	
	@Override
	public String fetchEmployeeNameByNo(int no) {
		return dao.getEmployeeNameByNo(no);
	}

	@Override
	public List<EmployeeDTO> fetchEmployeeDetailsByDesgs(String desg1, String desg2, String desg3) {
		//use DAO
		List<EmployeeBO> listBO = dao.getEmployeeDetailsByDesgs(desg1, desg2, desg3);
		//copy listBO to listDTO
		List<EmployeeDTO> listDTO = new ArrayList<>();
		listBO.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		//Convert DTO to BO
		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use DAO
		int count = dao.insertEmployee(bo);
		return count==1?"Employee Registered":"Employee not Registered";
	}

}
