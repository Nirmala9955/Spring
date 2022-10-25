package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
public class EmployeeInfo implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Type(type = "int")
	private Integer eid;
	
	@Column(length = 20)
	@Type(type = "string")
	private String ename;

	@Column(length = 20)
	@Type(type = "string")
	private String eadd;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dob;

	@Temporal(value = TemporalType.DATE)
	private Date doj;
	
	@Temporal(value = TemporalType.TIME)
	private Date batchTime;
	
}
