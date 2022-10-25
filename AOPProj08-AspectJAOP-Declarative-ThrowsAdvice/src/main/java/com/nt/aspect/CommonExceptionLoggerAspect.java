package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class CommonExceptionLoggerAspect {
	
	public void exceptionLogger(IllegalArgumentException ex) {
		System.out.println(ex+" exception is rised (exact match)");
	}

	public void exceptionLogger(Exception ex) {
		System.out.println(ex+" exception is rised");
	}

	public void exceptionLogger(JoinPoint jp, Exception ex) {
		System.out.println(ex+" exception is rised in "+jp.getSignature()+" with args "+Arrays.deepToString(jp.getArgs()));
	}
	
}
