package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;
import com.nt.service.ICollegeMgmtService;

public class MainControllerServlet extends HttpServlet {
	
	private ApplicationContext ctx = null;
	public void init() {
		//Create container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	}

	public void destroy() {
		((AbstractApplicationContext) ctx).close();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type = null;
		StudentDTO stuDTO = null;
		EmployeeDTO empDTO = null;
		ICollegeMgmtService service = null;
		String result = null, targetPage = null;
		RequestDispatcher rd = null;
		//get service class object
		service = ctx.getBean("clgService", ICollegeMgmtService.class);
		//Evaluate which form is submitting request to different the logics
		type = req.getParameter("type");
		if (type.equalsIgnoreCase("Student Registered")) {
			//get StudentDTO class object
			stuDTO = ctx.getBean("stuDTO", StudentDTO.class);
			//read form data and store to DTO object
			stuDTO.setId(Integer.parseInt(req.getParameter("sid")));
			stuDTO.setName(req.getParameter("sname"));
			stuDTO.setSadd(req.getParameter("saddress"));
			stuDTO.setCourse(req.getParameter("scourse"));
			stuDTO.setM1(Integer.parseInt(req.getParameter("sm1")));
			stuDTO.setM2(Integer.parseInt(req.getParameter("sm2")));
			stuDTO.setM3(Integer.parseInt(req.getParameter("sm3")));
			try {
				//use service
				result = service.enrollStudent(stuDTO);
				//keep result in request scope
				req.setAttribute("resultMessage", result);
				targetPage = "/show_result.jsp";
			} catch (Exception e) {
				targetPage = "/error.jsp";
				e.printStackTrace();
			}
		}
		else {
			//get EmployeeDTO class object
			empDTO = ctx.getBean("empDTO", EmployeeDTO.class);
			//read form data and store to DTO object
			empDTO.setId(Integer.parseInt(req.getParameter("eid")));
			empDTO.setName(req.getParameter("ename"));
			empDTO.setCompany(req.getParameter("ecompany"));
			empDTO.setSalary(Float.parseFloat(req.getParameter("esalary")));
			try {
				//use service
				result = service.enrollEmployee(empDTO);
				//keep result in request scope
				req.setAttribute("resultMessage", result);
				targetPage = "/show_result.jsp";
			} catch (Exception e) {
				targetPage = "/error.jsp";
				e.printStackTrace();
			}
		}
		//get Dispatcher
		rd = req.getRequestDispatcher(targetPage);
		//forward the request
		rd.forward(req, res);
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
