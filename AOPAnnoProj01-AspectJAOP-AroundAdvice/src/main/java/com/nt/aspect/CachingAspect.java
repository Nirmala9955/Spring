package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("cachingAspect")
@Aspect
@Order(3)
public class CachingAspect {
	
	private Map<String, Object> cacheMap = new HashMap<>();
	
	@Around("execution(float com.nt.service.BankService.*(..))")
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
	
}
