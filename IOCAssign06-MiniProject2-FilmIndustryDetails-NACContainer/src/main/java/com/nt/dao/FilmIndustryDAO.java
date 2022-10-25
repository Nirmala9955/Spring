package com.nt.dao;

import java.util.List;

import com.nt.bo.FilmIndustryBO;

public interface FilmIndustryDAO {
	public List<FilmIndustryBO> getFilmIndustrysByProfession(String profession) throws Exception;
}
