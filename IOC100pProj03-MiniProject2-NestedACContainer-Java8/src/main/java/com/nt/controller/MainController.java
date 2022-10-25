package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.vo.EmployeeVO;

@Controller("controller")
@Lazy
public class MainController {
	
	@Autowired
	private EmployeeMgmtService service;
	
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
