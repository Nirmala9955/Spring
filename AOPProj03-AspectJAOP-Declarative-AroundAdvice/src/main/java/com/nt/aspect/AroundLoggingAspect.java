package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundLoggingAspect {
	
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Entering into "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		Object returnVal = pjp.proceed();
		System.out.println("Entering into "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		return returnVal;
	} 
	
}
