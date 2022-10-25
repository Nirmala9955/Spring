package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.CricketerBO;
import com.nt.dao.CricketerDAO;
import com.nt.dto.CricketerDTO;

public class CricketerMgmtServiceImpl implements CricketerMgmtService {
	
	public CricketerDAO dao;
	
	public CricketerMgmtServiceImpl(CricketerDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<CricketerDTO> fetchCricketersByRole(String role) throws Exception {
		List<CricketerBO> listBO = null;
		List<CricketerDTO> listDTO = new ArrayList<>();
		//Covert desg into upper case
		role = role.toUpperCase();
		//use DAO
		listBO = dao.getCricketersByRole(role);
		listBO.forEach(bo -> {
			CricketerDTO dto = new CricketerDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSerialNo(listDTO.size()+1);
			//add each dto to listDTO
			listDTO.add(dto);
		});
		return listDTO;
	}

}