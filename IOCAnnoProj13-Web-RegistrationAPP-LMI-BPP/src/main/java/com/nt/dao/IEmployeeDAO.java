package com.nt.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
@Scope("singleton")
public interface IEmployeeDAO {
	public int registerEmployee(EmployeeBO bo) throws Exception;
}
