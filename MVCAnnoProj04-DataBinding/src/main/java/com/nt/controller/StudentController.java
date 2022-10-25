package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/register")
	public String showFrom(@ModelAttribute("stFrm") Student st) {
		st.setSadd("hyd");
		return "student_form";
	}

	@PostMapping("/register")
	public String processFrom(Map<String, Object> map, @ModelAttribute("stFrm") Student st) {
		System.out.println("StudentController.processFrom() : "+st);
		return "result";
	}
	
	/*@GetMapping("/link")
	public String getLinkData(Map<String, Object> map,
						@RequestParam("sno") int no,
						@RequestParam("sname") String name){
		System.out.println("Request Param: "+no+" "+name);
		return "show_params";					
	}*/
	
	/*	@GetMapping("/link")
		public String getLinkData(Map<String, Object> map,
				@RequestParam int sno,
				@RequestParam String sname){
			System.out.println("Request Param: "+sno+" "+sname);
			return "show_params";					
		}*/
	
	/*@GetMapping("/link")
	public String getLinkData(Map<String, Object> map,
			@RequestParam int sno,
			@RequestParam String sname,
			@RequestParam String[] sadd){
		System.out.println("Request Param: "+sno+" "+sname+" "+sadd[0]+" "+sadd[1]);
		return "show_params";					
	}*/
@GetMapping("/link")
	public String getLinkData(Map<String, Object> map,
			@RequestParam int sno,
			@RequestParam(required = false, defaultValue = "anonymous") String sname,
			@RequestParam List<String> sadd){
		System.out.println("Request Param: "+sno+" "+sname+" "+sadd.get(0)+" "+sadd.get(1));
		return "show_params";					
	}
	

}
