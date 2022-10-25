package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.vo.EmployeeVO;

public class MainController {
	
	private EmployeeMgmtService service;

	public MainController(EmployeeMgmtService service) {
		System.out.println(service);
		this.service = service;
	}
	
	public List<EmployeeVO> getEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
		List<EmployeeDTO> listDTO = null;
		List<EmployeeVO> listVO = new ArrayList<>();;
		//use service
		listDTO = service.fetchEmployeesByDesgs(desg1, desg2, desg3);
		listDTO.forEach(dto-> {		
			EmployeeVO vo = new EmployeeVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSerialNo(String.valueOf(dto.getSerialNo()));
			vo.setEmpno(String.valueOf(dto.getEmpno()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setDeptno(String.valueOf(dto.getDeptno()));
			//add vo to listVO
			listVO.add(vo);
		});
		return listVO;
	}
	
}
