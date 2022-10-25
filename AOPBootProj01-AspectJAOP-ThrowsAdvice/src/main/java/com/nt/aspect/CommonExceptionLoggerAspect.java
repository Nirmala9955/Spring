package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("celAspect")
@Aspect
public class CommonExceptionLoggerAspect {
	
	@AfterThrowing(pointcut = "execution(float com.nt.service.ShoppingStore.generateBill(..))", throwing = "ex")
	public void exceptionLogger(JoinPoint jp, Exception ex) {
		System.out.println(ex+" exception is rised in "+jp.getSignature()+" with args "+Arrays.deepToString(jp.getArgs()));
	}
	
}
