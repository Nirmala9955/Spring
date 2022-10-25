package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Person;

@Controller
public class PersonController {

	@GetMapping("/person")
	public String showHomePage(@ModelAttribute("perFrm") Person person) {
		return "person_form";
	}
	
	@PostMapping("/person")
	public String handleForm(Map<String, Object> map, @ModelAttribute("perFrm") Person per) {
		System.out.println("PersonController.handleForm()");
		return "register_success";
	}
	
	@ModelAttribute("gendersList")
	public List<String> populateGenders() {
		List<String> gendersList = List.of("Female", "Male");
		return gendersList;
	}
	
	@ModelAttribute("hobbiesList")
	public List<String> populateHobbies() {
		List<String> hobbiesList = List.of("reading", "romaing", "playing", "workouts", "sleeping");
		return hobbiesList;
	}

	@ModelAttribute("qualificationsList")
	public List<String> populateQualifications() {
		List<String> qualificationsList = List.of("BE", "MCA", "BCA", "M.Tech", "M.Sc");
		return qualificationsList;
	}
	
	@ModelAttribute("colorsList")
	public List<String> populateColors() {
		List<String> colorsList = List.of("Blue", "white", "Green", "Red", "Yellow", "Orange");
		return colorsList;
	}
	
	/*@InitBinder
	public void myInitBinder(ServletRequestDataBinder binder) {
		System.out.println("PersonController.myInitBinder()");
		SimpleDateFormat sdf = null;
		sdf =new SimpleDateFormat("dd-mm-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}*/
	
}
