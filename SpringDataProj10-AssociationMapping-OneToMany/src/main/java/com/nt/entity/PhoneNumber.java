	package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name="DATA_PHONENUMBER")
@Data
public class PhoneNumber implements Serializable {
	
	@Id
	private long mobileNo;
	
	@Column(length = 10)
	@Type(type = "string")
	private String type;
		
	@Column(length = 10)
	@Type(type = "string")
	private String provider;
	
}
