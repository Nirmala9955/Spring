package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.dto.FilmIndustryDTO;
import com.nt.service.FilmIndustryMgmtService;
import com.nt.vo.FilmIndustryVO;

public class MainController {
	
	private FilmIndustryMgmtService service;

	public MainController(FilmIndustryMgmtService service) {
		this.service = service;
	}
	
	public List<FilmIndustryVO> getFilmIndustrysByProfession(String profession) throws Exception {
		List<FilmIndustryDTO> listDTO = null;
		List<FilmIndustryVO> listVO = new ArrayList<>();;
		//use service
		listDTO = service.fetchFilmIndustrysByProfession(profession);
		listDTO.forEach(dto-> {		
			FilmIndustryVO vo = new FilmIndustryVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSerialNo(String.valueOf(dto.getSerialNo()));
			vo.setAge(String.valueOf(dto.getAge()));
			vo.setHeight(String.valueOf(dto.getHeight()));
			//add vo to listVO
			listVO.add(vo);
		});
		return listVO;
	}
	
}
