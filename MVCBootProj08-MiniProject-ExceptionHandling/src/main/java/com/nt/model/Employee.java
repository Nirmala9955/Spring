package com.nt.model;

import lombok.Data;

@Data
public class Employee {
	private Integer empNo;
	private String ename;
	private String job;
	private Float sal;
	private Integer deptNo;
	private String vflag="no";
}
