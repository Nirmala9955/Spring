package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.dto.CricketerDTO;
import com.nt.service.CricketerMgmtService;
import com.nt.vo.CricketerVO;

public class MainController {
	
	private CricketerMgmtService service;

	public MainController(CricketerMgmtService service) {
		this.service = service;
	}
	
	public List<CricketerVO> getCricketersByRole(String role) throws Exception {
		List<CricketerDTO> listDTO = null;
		List<CricketerVO> listVO = new ArrayList<>();;
		//use service
		listDTO = service.fetchCricketersByRole(role);
		listDTO.forEach(dto-> {		
			CricketerVO vo = new CricketerVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSerialNo(String.valueOf(dto.getSerialNo()));
			vo.setCricketerId(String.valueOf(dto.getCricketerId()));
			vo.setAge(String.valueOf(dto.getAge()));
			vo.setMatches(String.valueOf(dto.getMatches()));
			vo.setHs(String.valueOf(dto.getHs()));
			//add vo to listVO
			listVO.add(vo);
		});
		return listVO;
	}
	
}
