package com.nt.service;

public final class BankServiceImpl implements BankService {

	public final float calculateSimpleIntrestAmount(float pAmt, float rate, float time) {
		System.out.println("BankService : calculateSimpleIntrestAmount()");
		return (pAmt*rate*time)/100;
	}
}
