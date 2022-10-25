package com.nt.dto;

import lombok.Data;

@Data
public class BankAccountDTO {
	private Long accno;
	private String holderName;
	private Float balance;
	private String status;
}
