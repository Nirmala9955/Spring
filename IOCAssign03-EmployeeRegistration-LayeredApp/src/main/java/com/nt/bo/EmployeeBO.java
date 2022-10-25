package com.nt.bo;

public class EmployeeBO {
	
	//bean properties
	private String empName;
	private String empAddress;
	private String desg;
	private float basicSalary;
	private float netSalary;
	private float grossSalary;
	
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
	
	public float getNetSalary() {
		return netSalary;
	}
	
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}
	
	public float getGrossSalary() {
		return grossSalary;
	}
	
	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}

}
