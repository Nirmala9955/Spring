package com.nt.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class BrowserCheckingInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		String browser = null;
		RequestDispatcher rd = null;
		//get Browser details
		browser = req.getHeader("User-Agent");
		if (browser.contains("chrome")) {
			return true;
		} else {
			rd = req.getRequestDispatcher("/notvalidbrowser.jsp");
			rd.forward(req, res);
			return false;
		}
	}
}
