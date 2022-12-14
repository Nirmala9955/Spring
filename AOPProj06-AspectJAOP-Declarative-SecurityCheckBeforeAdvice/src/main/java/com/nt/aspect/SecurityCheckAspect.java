package com.nt.aspect;

import org.aspectj.lang.JoinPoint;

import com.nt.manager.AuthenticationManager;

public class SecurityCheckAspect {
	
	private AuthenticationManager manager;

	public SecurityCheckAspect(AuthenticationManager manager) {
		this.manager = manager;
	}
	
	public void check(JoinPoint jp) throws Throwable {
		if (!manager.validation())
			throw new IllegalArgumentException("Bad/ invalid cradentials");
	}
	
}

