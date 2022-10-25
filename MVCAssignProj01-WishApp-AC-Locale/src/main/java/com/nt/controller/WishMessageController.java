package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishMessageService;

public class WishMessageController extends AbstractController {
	
	private WishMessageService service = null;
	
	public WishMessageController(WishMessageService service) {
			this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msg = null;
		//use serive
		msg = service.getWishMessage();
		return new ModelAndView("result", "wishMessage", msg);
	}

}
