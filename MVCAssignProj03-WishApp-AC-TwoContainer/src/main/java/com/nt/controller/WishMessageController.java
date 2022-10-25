package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishMessageService;

@Controller
public class WishMessageController {
	
	@Autowired
	private WishMessageService service = null;
	
	@RequestMapping("/welcome")
	public String showHome(){
		//return MVN
		return "home";
	}
	
	@RequestMapping("/wish")
	public ModelAndView showWishMessage() {
		String msg = null;
		//use serive
		msg = service.getWishMessage();
		return new ModelAndView("result", "wishMessage", msg);
	}

}
