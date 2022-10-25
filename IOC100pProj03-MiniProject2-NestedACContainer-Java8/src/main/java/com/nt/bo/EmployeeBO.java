package com.nt.bo;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeBO implements Serializable {
	private Integer empno;
	private String ename;
	private String job;
	private Float sal;
	private Integer deptno;
}
