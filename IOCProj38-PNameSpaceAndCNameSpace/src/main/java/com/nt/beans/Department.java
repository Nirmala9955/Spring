package com.nt.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Department {
	private int dno;
	private String dname;
	private Date dos;
}
