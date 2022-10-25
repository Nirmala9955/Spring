package com.nt.service;

public class BankService {

	public float calculateSimpleIntrestAmount(float pAmt, float rate, float time) {
		System.out.println("BankService : calculateSimpleIntrestAmount()");
		return (pAmt*rate*time)/100;
	}
}
