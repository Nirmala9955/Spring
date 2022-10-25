package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {
	public int getEmployeeCount();
	public String getEmployeeNameByNo(int eno);
	public Map<String, Object> getEmployeeDetailsByNo(int eno);
	public List<Map<String, Object>> getEmployeesDetailsByDesg(String desg1, String desg2);
	public int insert(String name, String desg, float sal);
	public int addBonusToEmployeeByDesg(String desg, float bonus);
}
