package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CoronaPatientDTO implements Serializable {
	private String distName;
	private Integer positive;
	private Integer recovered;
	private Integer active;
}
