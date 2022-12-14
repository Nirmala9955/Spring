package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("logAspect")
@Aspect
@Order(5)
public class AroundLoggingAspect {
	
	@Around("execution(float com.nt.service.BankService.*(..))")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Entering into "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		Object returnVal = pjp.proceed();
		System.out.println("Entering into "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		return returnVal;
	} 
	
}
