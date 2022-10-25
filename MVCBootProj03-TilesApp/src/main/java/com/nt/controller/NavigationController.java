package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	
	@GetMapping("/home")
	public String showHome() {
		return "homeDef";
	}
	
	@GetMapping("/address")
	public String showAddress() {
		return "addressDef";
	}

	@GetMapping("/faculty")
	public String showFaculty() {
		return "facultyDef";
	}

	@GetMapping("/course")
	public String showcourse() {
		return "courseDef";
	}

}

