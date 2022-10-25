package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestControler {
	
	@RequestMapping(value = "/first", method = {RequestMethod.GET, RequestMethod.POST})
	public String showHomePage1() {
		System.out.println("TestControler.showHomePage1()");
		return "home_page";
	}
	
	/*@RequestMapping(method = RequestMethod.POST)
	public String showHomePage2() {
		System.out.println("TestControler.showHomePage2()");
		return "home_page";
	}*/
	
}
