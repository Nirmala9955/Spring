package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name = "DATA_USER")
@Data
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "int")
	private Integer userId;
	
	@Column(length = 20)
	@Type(type = "string")
	private String userName;

	@Column(length = 20)
	@Type(type = "string")
	private String address;
	
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_userId", referencedColumnName = "userId")
	private Set<PhoneNumber> phones;
	
}	
