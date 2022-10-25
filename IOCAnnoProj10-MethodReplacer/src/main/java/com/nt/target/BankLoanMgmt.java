package com.nt.target;

import java.util.Random;

public class BankLoanMgmt {
	
	public float calculateInterestAmount(float pAmt, float rate, float time) {
		System.out.println("BankLoanMgmt : calculateInterestAmount(-, -, -) - Compound intrest amount");
		return (float) (pAmt* Math.pow((1+rate/100), time) - pAmt);
	}
	
	public float getBalance() {
		System.out.println("BankLoanMgmt : getBalance()");
		return new Random().nextInt(1000000);
	}
	
}
