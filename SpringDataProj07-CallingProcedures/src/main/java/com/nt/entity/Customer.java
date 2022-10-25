package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
public class Customer implements Serializable {
	
	@Id
	@Type(type = "int")
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer cno;
	
	@Column(length = 15)
	@Type(type = "string")
	private String cname;

	@Column(length = 15)
	@Type(type = "string")
	private String cadd;
	
	@Type(type = "double")
	private Double bill_Amount;
	
}
