package com.nt.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.nt.entity.Customer;

@Transactional
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	@Procedure(procedureName = "GET_CUSTOMERS_COUNT_BY_ADDRS")
	int featchCustomersCountByAddress(String address);
	
	@Procedure
	int GET_CUSTOMERS_COUNT_BY_ADDRS(String address);
}	
