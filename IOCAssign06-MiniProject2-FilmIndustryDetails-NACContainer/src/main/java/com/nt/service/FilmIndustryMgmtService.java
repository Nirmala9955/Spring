package com.nt.service;

import java.util.List;

import com.nt.dto.FilmIndustryDTO;

public interface FilmIndustryMgmtService {
	public List<FilmIndustryDTO> fetchFilmIndustrysByProfession(String profession) throws Exception;
}
