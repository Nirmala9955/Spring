package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageController {
	
	@Autowired
	private IWishMessageService service;
	
	@GetMapping("/welcome")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/wish")
	public String showWishMessage(Map<String, Object> map) {
		//user Servicer
		String result = service.getWishMessage();
		map.put("wishMessage", result);
		return "result";
	}
	
}
