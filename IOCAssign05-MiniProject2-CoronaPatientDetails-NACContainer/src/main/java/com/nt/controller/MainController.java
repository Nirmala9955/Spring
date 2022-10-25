package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.dto.CoronaPatientDTO;
import com.nt.service.CoronaPatientMgmtService;
import com.nt.vo.CoronaPatientVO;

public class MainController {
	
	private CoronaPatientMgmtService service;

	public MainController(CoronaPatientMgmtService service) {
		this.service = service;
	}
	
	public List<CoronaPatientVO> getCoronaPatientsByDist(String dist) throws Exception {
		List<CoronaPatientDTO> listDTO = null;
		List<CoronaPatientVO> listVO = new ArrayList<>();;
		//use service
		listDTO = service.fetchCoronaPatientsByDist(dist);
		listDTO.forEach(dto-> {		
			CoronaPatientVO vo = new CoronaPatientVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setPositive(String.valueOf(dto.getPositive()));
			vo.setRecovered(String.valueOf(dto.getRecovered()));
			vo.setActive(String.valueOf(dto.getActive()));
			//add vo to listVO
			listVO.add(vo);
		});
		return listVO;
	}
	
}
