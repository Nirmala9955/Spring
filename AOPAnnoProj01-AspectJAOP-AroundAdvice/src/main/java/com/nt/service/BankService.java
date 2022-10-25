package com.nt.service;

import org.springframework.stereotype.Component;

@Component("bankService")
public class BankService {

	public float calculateSimpleIntrestAmount(float pAmt, float rate, float time) {
		System.out.println("BankService.calculateSimpleIntrestAmount()");
		return (pAmt * rate * time) / 100.0f;
	}

	public float calculateCompoundIntrestAmount(float pAmt, float rate, float time) {
		System.out.println("BankService.calculateCompoundIntrestAmount()");
		return (float) ((pAmt * Math.pow(1 + rate / 100, time)) - pAmt);
	}

}
