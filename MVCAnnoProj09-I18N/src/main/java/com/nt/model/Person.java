package com.nt.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Person {
	private String name; 
	private String address; 
	private Long mobileNo; 
}
