package com.nt.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeMgmtService {
	public int fetchEmpsCount();
	public String fetchEmployeeNameByNo(int eno);
	public Map<String, Object> fetchEmployeeDetailsByNo(int eno);
	public List<Map<String, Object>> fetchEmployeesDetailsByDesg(String desg1, String desg2);
	public String resgisteEmployee(String name, String desg, float sal);
	public String putBonusToEmployeeByDesg(String desg, float bonus);
}
