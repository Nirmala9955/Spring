package com.nt.beans;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoanAmountInterestCalculator {

	private LoanAmountDetails details;
	
	public float calculateInterestAmount() {
		return details.getPAmount()*details.getRate()*details.getTime();
	}
	
}
