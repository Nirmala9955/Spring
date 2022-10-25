package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CricketerDTO implements Serializable {
	private Integer serialNo;
	private Integer cricketerId;
	private String cricketerName;
	private Integer age;
	private String role;
	private Integer matches;
	private Integer hs;
}
