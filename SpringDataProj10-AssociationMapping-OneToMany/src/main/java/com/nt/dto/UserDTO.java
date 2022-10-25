package com.nt.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class UserDTO implements Serializable {
	
	private Integer userId;
	private String userName;
	private String address;
	private Set<PhoneNumberDTO> phones;
	
}
