package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	
	//bean properties
	private String empName;
	private String empAddress;
	private String desg;
	private float basicSalary;
	
	//setters and getters
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpAddress() {
		return empAddress;
	}
	
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	public String getDesg() {
		return desg;
	}
	
	public void setDesg(String desg) {
		this.desg = desg;
	}
	
	public float getBasicSalary() {
		return basicSalary;
	}
	
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	
}
