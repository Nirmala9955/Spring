package com.nt.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ILocaleInfoService;

@Controller
public class LocaleOperationsController {
	
	@Autowired
	private ILocaleInfoService service;
	
	@GetMapping("/welcome")
	public String showHomePage() {
		return "home";
	}

	
	
	@GetMapping("/countries")
	public String fetchCountries(Map<String, Object> map) {
		Set<String> countriesSet = null;
		//use Service
		countriesSet = service.getAllCountries();
		//add  object to mav object
		map.put("listInfo", countriesSet);
		map.put("operation", "contries");
		//retrun MAV
		return "show_result";
	}
}
