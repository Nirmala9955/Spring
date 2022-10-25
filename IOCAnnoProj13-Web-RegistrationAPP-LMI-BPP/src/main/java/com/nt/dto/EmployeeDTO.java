package com.nt.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nt.bo.BaseBean;

import lombok.Data;

@Data
@Component("empDTO")
@Scope("prototype")
public class EmployeeDTO extends BaseBean {
	private String company;
	private float salary;
}
