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
		this.service = service;
	}
	
	public List<EmployeeVO> getEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
		List<EmployeeDTO> listDTO = null;
		List<EmployeeVO> listVO = null;
		EmployeeVO vo = null;
		//use service
		listDTO = service.fetchEmployeesByDesgs(desg1, desg2, desg3);
		//covert DTO to VO
		listVO = new ArrayList<>();
		for (EmployeeDTO dto : listDTO) {
			vo = new EmployeeVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSerialNo(String.valueOf(dto.getSerialNo()));
			vo.setEmpno(String.valueOf(dto.getEmpno()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setDeptno(String.valueOf(dto.getDeptno()));
			//add vo to listVO
			listVO.add(vo);
		}
		return listVO;
	}
	
}
