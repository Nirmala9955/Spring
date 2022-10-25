package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataRendaringController {
	
	/*@GetMapping("/welcome")
	public String processData(Model model) {
		System.out.println("DataRendaringController.processData()");
		System.out.println(model.getClass());
		model.addAttribute("msg", "Welcome Here");
		return "display";
	}*/
	
	@GetMapping("/welcome")
	public String processData(Map<String, Object> map) {
		System.out.println("DataRendaringController.processData()");
		map.put(null, "Welcome Here");
		return "display";
	}
	
	/*@GetMapping("/welcome")
	public String processData(Model model) {
		String name[] = new String[] {"raja", "rani", "suresh"};
		List<String> fruitList = new ArrayList<>();
		fruitList.add("apple");
		fruitList.add("banana");
		fruitList.add("graps");
		Set<Long> phoneSet = new HashSet<>();
		phoneSet.add(45678234L);
		phoneSet.add(45678235L);
		phoneSet.add(45678236L);
		Map<String, Integer> ageMap = new HashMap<>();
		ageMap.put("raja", 30);
		ageMap.put("rani", 25);
		ageMap.put("suresh", 33);
		//add them i model attribute
		model.addAttribute("namesInfo", name);
		model.addAttribute("fruitsInfo", fruitList);
		model.addAttribute("phonesInfo", phoneSet);
		model.addAttribute("agesInfo", ageMap);
		return "display";
	}*/
	
	/*@GetMapping("/welcome")
	public String processData(Model model) {
		List<StudentDTO> listDTO = new ArrayList<>();
		listDTO.add(new StudentDTO(101, "raja", "hyd"));
		listDTO.add(new StudentDTO(102, "rani", "delhi"));
		listDTO.add(new StudentDTO(103, "suresh", "vizg"));
		//add them i model attribute
		model.addAttribute("studentDetails", listDTO);
		return "display";
	}*/
	
	/*@GetMapping("/welcome")
	public String processData(Map<String, Object> map) {
		System.out.println("DataRendaringController.processData()");
		System.out.println(map.getClass());
		map.put("msg", "Welcome Here");
		return "display";
	}*/
	
	/*@GetMapping("/welcome")
	public String processData(ModelMap map) {
		System.out.println("DataRendaringController.processData()");
		System.out.println(map.getClass());
		map.put(null, "Welcome Here");
		return "display";
	}*/
}
