package com.nt.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimingCheckingInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		int hours = 0;
		RequestDispatcher rd = null;
		//get Current day hour
		hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		//Checks the timing
		if (hours<9||hours>15) {
			rd = req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		} else 
		return true;
	}
	
}
