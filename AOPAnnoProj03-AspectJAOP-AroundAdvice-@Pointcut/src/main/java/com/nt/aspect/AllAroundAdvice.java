package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("allAround")
@Aspect
public class AllAroundAdvice {
	
	@Pointcut("execution(float com.nt.service.IBankService.*(..))")
	public void myPtc() {
		
	}
	
	@Around("myPtc()")
	@Order(100)
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Entering into "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		Object returnVal = pjp.proceed();
		System.out.println("Entering into "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		return returnVal;
	} 
	
	private Map<String, Object> cacheMap = new HashMap<>();
	
	@Around("myPtc()")
	@Order(20)
	public Object caching(ProceedingJoinPoint pjp) throws Throwable {
		//Prepare the kry having  methodName and arg value
		String key = pjp.getSignature()+Arrays.toString(pjp.getArgs());
		Object returnVal =null;
		if (!cacheMap.containsKey(key)) {
			//If key is not there in the cacheMap
			System.out.println("From target Method");
			//invoke the target method
			returnVal = pjp.proceed();
			//put the results in cacheMap
			cacheMap.put(key, returnVal);
		} 
		else {
			System.out.println("From cache");
			returnVal  = cacheMap.get(key);
		}
		return returnVal;
	}
	
	@Around("myPtc()")
	@Order(200)
	public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		long end = System.currentTimeMillis();
		System.out.println(pjp.getSignature()+" with args "+Arrays.deepToString(pjp.getArgs())+" has taken "+(end-start)+" ms.");
		return retVal;
	}
	
}
