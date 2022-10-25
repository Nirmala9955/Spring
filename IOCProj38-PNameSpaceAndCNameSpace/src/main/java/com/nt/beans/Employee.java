package com.nt.beans;

import java.util.Date;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class Employee {
	private int eno;
	private String ename;
	private Date dob;
	private Department dept;
}
