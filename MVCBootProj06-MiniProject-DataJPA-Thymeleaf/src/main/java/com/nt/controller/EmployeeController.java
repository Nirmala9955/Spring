package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.dto.EmployeeDTO;
import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeValidator validator;

	@Autowired
	private IEmployeeMgmtService service;

	@GetMapping("/welcome.htm")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/list_emps.htm")
	public String showEmployee(Map<String, Object> map) {
		List<EmployeeDTO> listDTO = null;
		// use service
		listDTO = service.fetchAllEmployees();
		// keep result in model attribute
		map.put("empsInfo", listDTO);
		return "show_report";
	}

	@GetMapping("/saveEmp.htm")
	public String showEmpRegistrationPage(@ModelAttribute("empFrm") Employee emp) {
		return "employee_register";
	}

	@PostMapping("/saveEmp.htm")
	public String saveEmployee(RedirectAttributes redirect, @ModelAttribute("empFrm") Employee emp,
			BindingResult errors) {
		EmployeeDTO dto = null;
		String result = null;

		// Enable server side form validation only when client side form validation are not done.
		if (emp.getVflag().equalsIgnoreCase("no")) {
			// Perform Form validation
			if (validator.supports(emp.getClass()))
				validator.validate(emp, errors);
		}

		// business logic error
		if (emp.getJob().equalsIgnoreCase("Netaji") || emp.getJob().equalsIgnoreCase("Actor"))
			errors.rejectValue("job", "blocked.jobs");

		// if form validation errors are there launch form page
		if (errors.hasErrors())
			return "employee_register";

		// convert model to dto
		dto = new EmployeeDTO();
		BeanUtils.copyProperties(emp, dto);
		// use service
		result = service.registerEmployee(dto);
		// keep in result in flash attribute special map object
		redirect.addFlashAttribute("resultMsg", result);
		// return LVN
		return "redirect:list_emps.htm";
	}

	@GetMapping("/deleteEmp.htm")
	public String removeEmployee(RedirectAttributes redirect, @RequestParam int eno) {
		// use service
		service.removeEmployeeById(eno);
		// add result to flash attribute
		redirect.addFlashAttribute("resultMsg", "Employee is Deleted");
		return "redirect:list_emps.htm";
	}

	@GetMapping("/editEmp.htm")
	public String showEditForm(@ModelAttribute Employee emp, @RequestParam int eno) {
		EmployeeDTO dto = null;
		// use Service
		dto = service.fetchEmployeeById(eno);
		// convert DTO to Model
		BeanUtils.copyProperties(dto, emp);
		return "employee_edit";
	}

	@PostMapping("/editEmp.htm")
	public String updateEmployee(RedirectAttributes redirect, @ModelAttribute Employee employee, BindingResult errors) {
		EmployeeDTO dto = null;
		String result = null;

		// Enable server side form validation only when client side form validation are
		// not done.
		if (employee.getVflag().equalsIgnoreCase("no")) {
			// Perform Form validation
			if (validator.supports(employee.getClass()))
				validator.validate(employee, errors);
		}
		// business logic error
		if (employee.getJob().equalsIgnoreCase("Netaji") || employee.getJob().equalsIgnoreCase("Actor"))
			errors.rejectValue("job", "blocked.jobs");

		// if form validation errors are there launch form page
		if (errors.hasErrors())
			return "employee_edit";

		// convert model to dto
		dto = new EmployeeDTO();
		BeanUtils.copyProperties(employee, dto);
		// use Service
		result = service.ModifyEmployeeById(dto);
		// add to flash attributr
		redirect.addFlashAttribute("resultMsg", result);
		return "redirect:list_emps.htm";
	}

	@ModelAttribute("deptsInfo")
	public List<Integer> populateDeptsNos() {
		// use service
		return service.fetchALLDeptNo();
	}

}
