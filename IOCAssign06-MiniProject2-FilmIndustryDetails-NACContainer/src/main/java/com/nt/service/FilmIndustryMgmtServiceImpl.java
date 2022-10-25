package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.FilmIndustryBO;
import com.nt.dao.FilmIndustryDAO;
import com.nt.dto.FilmIndustryDTO;

public class FilmIndustryMgmtServiceImpl implements FilmIndustryMgmtService {
	
	public FilmIndustryDAO dao;
	
	public FilmIndustryMgmtServiceImpl(FilmIndustryDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<FilmIndustryDTO> fetchFilmIndustrysByProfession(String profession) throws Exception {
		List<FilmIndustryBO> listBO = null;
		List<FilmIndustryDTO> listDTO = new ArrayList<>();
		//Covert desg into upper case
		profession = profession.toUpperCase();
		//use DAO
		listBO = dao.getFilmIndustrysByProfession(profession);
		listBO.forEach(bo -> {
			FilmIndustryDTO dto = new FilmIndustryDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSerialNo(listDTO.size()+1);
			//add each dto to listDTO
			listDTO.add(dto);
		});
		return listDTO;
	}

}