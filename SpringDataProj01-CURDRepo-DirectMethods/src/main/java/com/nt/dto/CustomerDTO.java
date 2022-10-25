package com.nt.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {
	@NonNull
	private Integer cno;
	private String cname;
	private String cadd;
	private double billAmount;
}
