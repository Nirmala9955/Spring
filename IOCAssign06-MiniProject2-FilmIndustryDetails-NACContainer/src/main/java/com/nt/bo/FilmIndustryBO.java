package com.nt.bo;

import java.io.Serializable;

import lombok.Data;

@Data
public class FilmIndustryBO implements Serializable {
	private String name;
	private String nickName;
	private String profession;
	private Integer age;
	private Float height;
	private String debut;
}
