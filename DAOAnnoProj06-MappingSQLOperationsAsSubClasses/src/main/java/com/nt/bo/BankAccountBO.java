package com.nt.bo;

import lombok.Data;

@Data
public class BankAccountBO {
	private Long accNo;
	private String holderName;
	private Float balance;
	private String status;
}
