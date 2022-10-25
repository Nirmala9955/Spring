package com.nt.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CADD=?
	List<Customer> findByCadd(String address);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CNAME=?
	List<Customer> findByCname(String name);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE BILLAMT>?
	List<Customer> findByBillAmountGreaterThan(double amount);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE BILLAMT<?
	List<Customer> findByBillAmountLessThan(double amount);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CNAME LIKE 'r%'
//	List<Customer> findByCnameLike(String initChars);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CNAME LIKE 'r%'
	List<Customer> findByCnameStartingWith(String initChars);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CNAME LIKE '%h'
	List<Customer> findByCnameEndingWith(String lastChars);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CNAME LIKE '%j%'
	List<Customer> findByCnameContaining(String Chars);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CADD IS NULL 
	Iterable<Customer> findByCaddIsNull();	
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CADD NOt NULL 
	Iterable<Customer> findByCaddIsNotNull();
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CNAME LIKE '____' 
	Iterable<Customer> findByCnameLike(String chars);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CADD LIKE '____%' 
	Iterable<Customer> findByCaddLike(String chars);
	
	//---------------Working with More than one property Condition
	
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE BILLAMT>400 AND BILLAMT<5000
	Iterable<Customer> findByBillAmountGreaterThanAndBillAmountLessThan(double min, double max);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE BILLAMT BETWEEN (4000, 5000)
	Iterable<Customer> findByBillAmountBetween(double min, double max);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CNAME='raja' OR CADD='hyd'
	Iterable<Customer> findByCnameEqualsOrCaddEquals(String name, String address);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE BILLAMT BETWEEN (4000, 5000) ORDER BY CNAME DESC
	Iterable<Customer> findByBillAmountBetweenOrderByCnameDesc(double min, double max);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CADD <> 'hyd'
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CADd != 'hyd'
	Iterable<Customer> findByCaddNot(String name);
	//SELECT CNO, CNAME, CADD, BILLAMT FROM CUSTOMER WHERE CADD IN ('hyd', 'vizg, 'delihi');
	Iterable<Customer> findByCaddIn(Collection<String> citis);

}
