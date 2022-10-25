package com.nt.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@AllArgsConstructor
@Data
public class StudentDTO implements Serializable {
	private int sno;
	private String sname;
	private String sadd;
}
