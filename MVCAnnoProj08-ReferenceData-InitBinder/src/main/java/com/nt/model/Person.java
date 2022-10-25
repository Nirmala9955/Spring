package com.nt.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Person {
	private String name; 
	private String address; 
	private long mobileNo; 
	private String gender="female"; 
	private String[] hobbies=new String[]{"sleeping", "reading"}; 
	private String qualification; 
	private String[] colors=new String[]{"red", "white"}; 
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob; 
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date doj;  
	public Float salary;
}
