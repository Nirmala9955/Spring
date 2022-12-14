package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nt.bo.EmployeeBO;

public interface EmployeeRepository extends CrudRepository<EmployeeBO, Integer> {
	@Query("SELECT DISTINCT deptNo FROM EmployeeBO  WHERE deptNo IS NOT NULL")
	public List<Integer> getAllDeptNos();
}
