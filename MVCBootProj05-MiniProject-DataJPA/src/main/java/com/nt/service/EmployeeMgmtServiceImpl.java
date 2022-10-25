package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.EmployeeBO;
import com.nt.dto.EmployeeDTO;
import com.nt.repository.EmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<EmployeeDTO> fetchAllEmployees() {
		List<EmployeeBO> listBO = null;
		List<EmployeeDTO> listDTO = new ArrayList<>();
		//use Repo
		listBO = (List<EmployeeBO>) empRepo.findAll();
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
		//convert DTO to bo
		bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use repo
		bo = empRepo.save(bo);
		return bo!=null?"Employee Registered":"Employee not Registered";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Integer> fetchALLDeptNo() {
		// use repo
		return empRepo.getAllDeptNos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void removeEmployeeById(int id) {
		int count = 0;
		//use Repo
		empRepo.deleteById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public EmployeeDTO fetchEmployeeById(int id) {
		EmployeeDTO dto = null;
		EmployeeBO bo = null;
		//use Repo
		bo = empRepo.findById(id).get();
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
		//use Repo
		bo = empRepo.save(bo);
		return bo==null?dto.getEmpNo()+" employee details are not found to update":dto.getEmpNo()+" employee details are found to update";
	}

}
