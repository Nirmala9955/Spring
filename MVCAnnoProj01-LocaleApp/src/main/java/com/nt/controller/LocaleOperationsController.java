package com.nt.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ILocaleInfoService;

@Controller
public class LocaleOperationsController {
	
	@Autowired
	private ILocaleInfoService service;
	
	@RequestMapping("/welcome")
	public String showHomePage() {
		return "home";
	}

	/*@RequestMapping("/countries")
	public ModelAndView fetchCountries() {
		Set<String> countriesSet = null;
		//use Service
		countriesSet = service.getAllCountries();
		//retrun MAV
		return new ModelAndView("show_result", "listInfo", countriesSet);
	}*/

	/*@RequestMapping("/countries")
	public ModelAndView fetchCountries() {
		Set<String> countriesSet = null;
		ModelAndView mav = null;
		//use Service
		countriesSet = service.getAllCountries();
		//add  object to mav object
		mav = new ModelAndView();
		mav.addObject("listInfo", countriesSet);
		mav.addObject("operation", "contries");
		mav.setViewName("show_result");
		//retrun MAV
		return mav;
	}*/
	
	/*@RequestMapping("/countries")
	public String fetchCountries(Map<String, Object> map) {
		Set<String> countriesSet = null;
		//use Service
		countriesSet = service.getAllCountries();
		//add  object to mav object
		map.put("listInfo", countriesSet);
		map.put("operation", "contries");
		//retrun MAV
		return "show_result";
	}*/
	
	/*@RequestMapping("/countries")
	public String fetchCountries(ModelMap map) {
		Set<String> countriesSet = null;
		//use Service
		countriesSet = service.getAllCountries();
		//add  object to mav object
		map.put("listInfo", countriesSet);
		map.put("operation", "contries");
		//retrun MAV
		return "show_result";
	}*/
	
	/*@RequestMapping("/countries")
	public String fetchCountries(Model model) { 
		Set<String> countriesSet = null;
		//use Service
		countriesSet = service.getAllCountries();
		//add  object to mav object
		model.addAttribute("listInfo", countriesSet);
		model.addAttribute("operation", "countries");
		//retrun LVN
		return "show_result";
	}*/
	
	/*@RequestMapping("/countries")
	public void fetchCountries(Model model) { 
		Set<String> countriesSet = null;
		//use Service
		countriesSet = service.getAllCountries();
		//add  object to mav object
		model.addAttribute("listInfo", countriesSet);
		model.addAttribute("operation", "countries");
	}*/
	
	/*@RequestMapping("/countries")
	public void fetchCountries(ModelAndView mav) {
		Set<String> countriesSet = null;
		//use Service
		countriesSet = service.getAllCountries();
		//add  object to mav object
		mav.addObject("listInfo", countriesSet);
		mav.addObject("operation", "countries");
		mav.setViewName("show_result");
	}*/
	
	/*@RequestMapping("/countries")
	public Map<String, Object> fetchCountries() {
		Set<String> countriesSet = null;
		Map<String, Object> map = new HashMap<>();
		//use Service
		countriesSet = service.getAllCountries();
		//add  object to mav object
		map.put("listInfo", countriesSet);
		map.put("operation", "countries");
		return map;
	}*/
	
	/*@RequestMapping("/countries/add")
	public void fetchCountries(Model model) { 
		Set<String> countriesSet = null;
		//use Service
		countriesSet = service.getAllCountries();
		//add  object to mav object
		model.addAttribute("listInfo", countriesSet);
		model.addAttribute("operation", "countries");
	}*/
	
	/*@RequestMapping("/countries/add")
	public Map<String, Object> fetchCountries() {
		Set<String> countriesSet = null;
		Map<String, Object> map = new HashMap<>();
		//use Service
		countriesSet = service.getAllCountries();
		//add  object to mav object
		map.put("listInfo", countriesSet);
		map.put("operation", "countries");
		return map;
	}*/

	@RequestMapping("/countries")
	public Model fetchCountries() {
		Set<String> countriesSet = null;
		Model model = null;
		//use Service
		countriesSet = service.getAllCountries();
		//add  object to model object
		model = new ExtendedModelMap();
		model.addAttribute("listInfo", countriesSet);
		model.addAttribute("operation", "countries");
		return model;
	}
}
