package com.nt.bo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CricketerBO implements Serializable {
	private Integer serialNo;
	private Integer cricketerId;
	private String cricketerName;
	private Integer age;
	private String role;
	private Integer matches;
	private Integer hs;
}
