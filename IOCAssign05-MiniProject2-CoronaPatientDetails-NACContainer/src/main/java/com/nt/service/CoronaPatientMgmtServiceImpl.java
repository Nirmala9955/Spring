package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.CoronaPatientBO;
import com.nt.dao.CoronaPatientDAO;
import com.nt.dto.CoronaPatientDTO;

public class CoronaPatientMgmtServiceImpl implements CoronaPatientMgmtService {
	
	public CoronaPatientDAO dao;
	
	public CoronaPatientMgmtServiceImpl(CoronaPatientDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<CoronaPatientDTO> fetchCoronaPatientsByDist(String dist) throws Exception {
		List<CoronaPatientBO> listBO = null;
		List<CoronaPatientDTO> listDTO = new ArrayList<>();
		//Covert desg into upper case
		dist = dist.toUpperCase();
		//use DAO
		listBO = dao.getCoronaPatientsByDist(dist);
		listBO.forEach(bo -> {
			CoronaPatientDTO dto = new CoronaPatientDTO();
			BeanUtils.copyProperties(bo, dto);
			//add each dto to listDTO
			listDTO.add(dto);
		});
		return listDTO;
	}

}