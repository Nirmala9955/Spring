package com.nt.service;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeInfoDTO;
import com.nt.entity.EmployeeInfo;
import com.nt.repo.EmployeeInfoRepo;

@Service("empService")
public class EmployeeInfoMgmtServiceImpl implements EmployeeInfoMgmtService {
	
	@Autowired
	private EmployeeInfoRepo empRepo;
	
	@Override
	public Integer registerEmployee(EmployeeInfoDTO dto) {
		EmployeeInfo entity = null;
		//Convert DTO to entity
		entity = new EmployeeInfo();
		BeanUtils.copyProperties(dto, entity);
		//use empRepo
		return empRepo.save(entity).getEid();
	}

	@Override
	public Iterable<EmployeeInfoDTO> getAllEmployeeInformation() {
		Iterable<EmployeeInfo> itEntity = null;
		Iterable<EmployeeInfoDTO> itDTO = new ArrayList<>();		
		//use empReop
		itEntity = empRepo.findAll();
		//convert itEntity to itDTO
		itEntity.forEach(entity->{
			EmployeeInfoDTO dto = new EmployeeInfoDTO();
			BeanUtils.copyProperties(entity, dto);
			((ArrayList<EmployeeInfoDTO>) itDTO).add(dto);
		});
		return itDTO;
	}

}
