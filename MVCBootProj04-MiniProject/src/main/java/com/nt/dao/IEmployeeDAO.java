package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {
	public List<EmployeeBO> getAllEmployees();
	public int InsertEmployee(EmployeeBO bo);
	public List<Integer> getAllDeptNos();
	public int deleteEmployeeById(int id);
	public EmployeeBO getEmployeeById(int id);
	public int updateEmployee(EmployeeBO bo);
}
