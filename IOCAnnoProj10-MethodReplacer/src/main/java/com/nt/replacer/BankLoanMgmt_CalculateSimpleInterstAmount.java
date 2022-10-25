package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

@Component("bankAccR")
public class BankLoanMgmt_CalculateSimpleInterstAmount implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("BankLoanMgmt_CalculateSimpleInterstAmount : reimplement(-, -, -,) : Simple interest amount");
		float pAmt = 0.0f;
		float rate = 0.0f;
		float time = 0.0f;
		//get target class object
		pAmt = (float) args[0];
		rate = (float) args[0];
		time = (float) args[0];
		//write new business logic (Simple interest amount)
		return (pAmt*rate*time)/100.0f;
	}

}
