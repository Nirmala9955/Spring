package com.cb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cb.service.ICrickBuzzScoreMgmtService;

public class MainControllerServlet extends HttpServlet {
	
	private ApplicationContext ctx;
	
	@Override
	public void init() throws ServletException {
		ctx = new ClassPathXmlApplicationContext("com/cb/cfgs/applicationContext.xml");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int matchId = 0;
		ICrickBuzzScoreMgmtService service = null;
		String score = null;
		RequestDispatcher rd = null;
		//read additional request param value
		matchId = Integer.parseInt(req.getParameter("mid"));
		//get local service bean object
		service = ctx.getBean("cbService", ICrickBuzzScoreMgmtService.class);
		//use local service
		score = service.fetchScore(matchId);
		//kep score in request scope
		req.setAttribute("scoreInfo", score);
		//forward to result.jsp
		rd = req.getRequestDispatcher("/result.jsp");
		rd.forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	@Override
	public void destroy() {
		((AbstractApplicationContext) ctx).close();
	}
	
}
