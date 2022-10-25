package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceMonitoringAspect {
	
	public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis(); //Pre logic
		Object returnVal = pjp.proceed();
		long end = System.currentTimeMillis(); //Post logic
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+" ms.");
		return returnVal;
	}
	
}
