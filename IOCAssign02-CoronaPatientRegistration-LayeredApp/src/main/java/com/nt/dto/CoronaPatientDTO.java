package com.nt.dto;

import java.io.Serializable;

public class CoronaPatientDTO implements Serializable {
	
	//bean properties
	private String patientName;
	private String patientAddress;
	private int patientAge;
	private String hospitalName;	
	private int noOfDays;
	
	//setters and getters
	public String getPatientName() {
		return patientName;
	}
	
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String getPatientAddress() {
		return patientAddress;
	}
	
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	
	public int getPatientAge() {
		return patientAge;
	}
	
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public int getNoOfDays() {
		return noOfDays;
	}
	
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	
}
