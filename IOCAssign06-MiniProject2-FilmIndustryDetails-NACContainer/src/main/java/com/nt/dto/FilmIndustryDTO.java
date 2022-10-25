package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class FilmIndustryDTO implements Serializable {
	private Integer serialNo;
	private String name;
	private String nickName;
	private String profession;
	private Integer age;
	private Float height;
	private String debut;
}
