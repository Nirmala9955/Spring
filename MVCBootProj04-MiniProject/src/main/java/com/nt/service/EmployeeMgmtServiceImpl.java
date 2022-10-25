package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDAO dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EmployeeDTO> fetchAllEmployees() {
		List<EmployeeBO> listBO = null;
		List<EmployeeDTO> listDTO = new ArrayList<>();
		//use DAO
		listBO = dao.getAllEmployees();
		//convert listBO to listDTO 
		listBO.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSerialNo(listDTO.size()+1);
			dto.setGrossSalary(dto.getSal()+dto.getSal()*0.3f);
			dto.setNetSalary(dto.getGrossSalary()+dto.getGrossSalary()*0.1f);
			dto.setSal(Math.round(dto.getSal()));
			listDTO.add(dto);
		});
		
		return listDTO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo = null;
		int count = 0;
		//convert DTO to bo
		bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count = dao.InsertEmployee(bo);
		return count!=0?"Employee Registered":"Employee not Registered";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Integer> fetchALLDeptNo() {
		// use dao
		return dao.getAllDeptNos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String removeEmployeeById(int id) {
		int count = 0;
		//use DAO
		count = dao.deleteEmployeeById(id);
		return count==0?id+" Employee not found for deletion":id+" Employee found and deleted";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public EmployeeDTO fetchEmployeeById(int id) {
		EmployeeDTO dto = null;
		EmployeeBO bo = null;
		//use DAO
		bo = dao.getEmployeeById(id);
		//convert bo to dto
		dto =  new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String ModifyEmployeeById(EmployeeDTO dto) {
		EmployeeBO bo = null;
		int count = 0;
		//convert DTO to BO
		bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use Service
		count = dao.updateEmployee(bo);
		return count==0?dto.getEmpNo()+" employee details are not found to update":dto.getEmpNo()+" employee details are found to update";
	}

}
