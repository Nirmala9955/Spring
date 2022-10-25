package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {
	public String getEmployeeNameByNo(int no);
	public List<EmployeeBO> getEmployeeDetailsByDesgs(String desg1, String desg2, String desg3);
	public int insertEmployee(EmployeeBO bo);
}
