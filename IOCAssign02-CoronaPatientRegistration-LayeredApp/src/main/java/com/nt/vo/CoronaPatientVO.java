package com.nt.vo;

public class CoronaPatientVO {
	
	//bean properties
	private String patientName;
	private String patientAddress;
	private String patientAge;
	private String hospitalName;	
	private String noOfDays;
	
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
	
	public String getPatientAge() {
		return patientAge;
	}
	
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public String getNoOfDays() {
		return noOfDays;
	}
	
	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}
	
}
