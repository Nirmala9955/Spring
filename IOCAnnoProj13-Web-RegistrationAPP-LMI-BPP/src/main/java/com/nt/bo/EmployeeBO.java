package com.nt.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("empBO")
@Scope("prototype")
public class EmployeeBO extends BaseBean {
	private String company;
	private float salary;
	private float grossSalary;
	private float netSalary;
}
