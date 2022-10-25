package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repo.EmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public String registerEmployee(Employee doc) {
		//use empRepo
		return "Document is saved with Id : "+empRepo.save(doc).getEid();
	}

	@Override
	public List<Employee> findAllEmployees() {
		//use empRepo
		return empRepo.findAll();
	}

	@Override
	public Employee findEmpById(int id) {
		Optional<Employee> optional = null;
		optional = empRepo.findById(id);
		return optional.get();
	}

	@Override
	public String updateEmployeeSalary(int id, double bonus) {
		Optional<Employee> optional = null;
		Employee doc = null;
		optional = empRepo.findById(id);
		if (optional.isPresent()) {
			doc = optional.get();
			doc.setSalary(doc.getSalary()+bonus);
			return doc.getEname()+" your salary is hiked by "+bonus+" new salary is : "+empRepo.save(doc).getSalary(); 
		} 
		else
			return "Employee record not found";
	}

	@Override
	public String removeEmployee(int id) {
		if (empRepo.findById(id).isPresent()) { 
			empRepo.delete(empRepo.findById(id).get());
			return id+" Employee is deleted";
		}
		else
			return "Employee record not found";
	}

}
