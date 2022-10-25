package com.nt.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO implements Serializable {
	private int sno;
	private String sname;
	private String address;
	private float avg;
}

