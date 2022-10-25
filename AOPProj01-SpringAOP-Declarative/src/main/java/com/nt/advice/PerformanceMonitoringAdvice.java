package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitoringAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("PerformanceMonitoringAdvice.invoke()");
		long startTime = System.currentTimeMillis(); //Pre logics
		//To modify the target method arg value
		Object args[] = invocation.getArguments();
		if (((float)args[0])<50000)
			args[1] = ((float)args[1])-0.5f;
		//Controlling target method execution
		if (((float)args[0])<0 || ((float)args[1])<0 || ((float)args[2])<0) 
			throw new IllegalArgumentException("Invalid inputs");
		Object returnVal = invocation.proceed(); //invokes the target method
		long endTime = System.currentTimeMillis(); //Post logics
		System.out.println(invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments())+" has taken "+(endTime-startTime)+"ms.");
		//To modifying the returnVal
		returnVal=((float)returnVal)+((float)returnVal)*0.5f;
		return returnVal;
	}

}
