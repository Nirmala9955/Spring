package com.nt.beans;

import java.util.Date;

public class PersonInfo {
	
	//Bean Properties 
	private long aadharNumber;
	private String name;
	private Date dob;
	private Date doj;
	private Date dom;
	
	public PersonInfo(long aadharNumber, String name, Date dob, Date doj, Date dom) {
		System.out.println("PersonInfo : PersonInfo(-,-,-,-)");
		this.aadharNumber = aadharNumber;
		this.name = name;
		this.dob = dob;
		this.doj = doj;
		this.dom = dom;
	}

	@Override
	public String toString() {
		return "PersonInfo [aadharNumber=" + aadharNumber + ", name=" + name + ", dob=" + dob + ", doj=" + doj
				+ ", dom=" + dom + "]";
	}
		
}
