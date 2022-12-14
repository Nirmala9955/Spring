package com.nt.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
	
@Controller
public class ShowBrowserController {
	
	@GetMapping("/welcome")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/browser")
	public String getBrowserName(Map<String, Object> map, HttpServletRequest req) {
		//get Browser name
		String brName = req.getHeader("user-agent");
		//keep browser name as model attribute
		map.put("browser", brName);
		return "result";
	}
	
}
