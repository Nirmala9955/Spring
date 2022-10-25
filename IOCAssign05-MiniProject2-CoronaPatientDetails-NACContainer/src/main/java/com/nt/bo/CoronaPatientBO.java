package com.nt.bo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CoronaPatientBO implements Serializable {
	private String distName;
	private Integer positive;
	private Integer recovered;
	private Integer active;
}
