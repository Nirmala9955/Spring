package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.dto.StudentDTO;
import com.nt.service.IStudentMgmtService;

@Controller
public class StudentOperatorController {
	
	@Autowired
	private IStudentMgmtService service;
	
	@GetMapping("/home")
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/pdf_report")
	public String showPdfReport(Map<String, Object> map) {
		//use service
		List<StudentDTO> listDTO = service.getAllStudent();
		//Keep in mode attribute
		map.put("studentsInfo", listDTO);
		return "pdfView";
	}

	@GetMapping("/excel_report")
	public String showExcelReport(Map<String, Object> map) {
		//use service
		List<StudentDTO> listDTO = service.getAllStudent();
		//Keep in mode attribute
		map.put("studentsInfo", listDTO);
		return "excelView";
	}
	
}
