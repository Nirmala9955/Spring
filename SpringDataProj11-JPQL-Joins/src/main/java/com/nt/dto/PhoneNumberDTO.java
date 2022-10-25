package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PhoneNumberDTO implements Serializable {
	
	private long mobileNo;
	private String type;
	private String provider;
	
}
