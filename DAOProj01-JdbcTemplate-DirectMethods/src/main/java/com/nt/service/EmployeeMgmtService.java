package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.IEmployeeDAO;

public class EmployeeMgmtService implements IEmployeeMgmtService {
	
	private IEmployeeDAO dao;
	
	public EmployeeMgmtService(IEmployeeDAO dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public int fetchEmpsCount() {
		//use dao
		return dao.getEmployeeCount();
	}
	
	@Override
	public String fetchEmployeeNameByNo(int eno) {
		return dao.getEmployeeNameByNo(eno);
	}
	
	@Override
	public Map<String, Object> fetchEmployeeDetailsByNo(int eno) {
		return dao.getEmployeeDetailsByNo(eno);
	}
	 
	@Override
	public List<Map<String, Object>> fetchEmployeesDetailsByDesg(String desg1, String desg2) {
		return dao.getEmployeesDetailsByDesg(desg1, desg2);
	}
	
	@Override
	public String resgisteEmployee(String name, String desg, float sal) {
		int count = 0;
		//use dao
		count = dao.insert(name, desg, sal);
		return count==0?"Employee is not registered":"Employee is registered";
	}
	
	@Override
	public String putBonusToEmployeeByDesg(String desg, float bonus) {
		int count = 0;
		//use dao
		count = dao.addBonusToEmployeeByDesg(desg, bonus);
		return count==0?desg+" Employee record found for add bouns":count+" No. of records are added with bouns";
	}
	
}
