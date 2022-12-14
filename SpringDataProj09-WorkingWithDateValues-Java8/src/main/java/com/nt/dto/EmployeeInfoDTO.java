package com.nt.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class EmployeeInfoDTO implements Serializable {
	
	private Integer eid;
	private String ename;
	private String eadd;
	private LocalDateTime dob;
	private LocalDate doj;
	private LocalTime batchTime;
	
}
