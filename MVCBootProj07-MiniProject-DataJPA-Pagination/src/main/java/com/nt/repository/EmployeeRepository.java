package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.bo.EmployeeBO;

public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeBO, Integer> {
	@Query("SELECT DISTINCT deptNo FROM EmployeeBO  WHERE deptNo IS NOT NULL")
	public List<Integer> getAllDeptNos();
}
