package com.nt.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Customer;

@Transactional
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	//Select bulk operation with positional param (Entity  query)
	@Query("FROM Customer")
	Iterable<Customer> getAllCustomers();
	
	@Query("FROM Customer WHERE cadd=?1")
	Iterable<Customer> getCustomerByCity(String city);
	
	@Query("FROM Customer WHERE billAmount>=?1 AND billAmount<=?2")
	Iterable<Customer> getCustomerByBillAmountRange(double start, double end);
	
	//Select bulk operation with Named param (Entity query)
	/*@Query("FROM Customer WHERE cadd IN(:cityOne, :cityTwo, :cityThree)")
	Iterable<Customer> getCustomerByCityNames(@Param("cityOne")String city1, 
												@Param("cityTwo")String city2, 
												@Param("cityThree")String city3);*/
	
	@Query("FROM Customer WHERE cadd IN(:cityOne, :cityTwo, :cityThree)")
	Iterable<Customer> getCustomerByCityNames(String cityOne, String cityTwo, String cityThree);
	
	//@Query("FROM Customer WHERE cname=:name")	
	//Iterable<Customer> getCustomerByName(String name); 
	
	/*@Query("FROM Customer WHERE cno>=?1 AND cno<=:end")
	Iterable<Customer> getCustomerByCnoRange(double start, double end);*/
	
	//Select bulk operation with Named param (Scalar query) Multiple columns
	@Query("SELECT cno, cname FROM Customer WHERE cadd=:city")
	Iterable<Object[]> getCustomerValuesByCity(String city);
	
	//Select bulk operation with Named param (Scalar query) specific single columns
	@Query("SELECT billAmount FROM Customer WHERE cadd in (:city1, :city2)")
	Iterable<Double> getBillAmountByCities(String city1, String city2);
	
	// @Query(value="select e from Employee e where empName = ?1 limit 1", nativeQuery=true)
	@Query("SELECT billAmount FROM Customer WHERE cadd in (:city1, :city2)")
	String getCustomerNameById();
	
	//Single Row Select operation HQL/ JPQL (Entity query) specific single columns
	@Query("FROM Customer WHERE cname= :name")
	Customer getCustomerByName(String name);

	//Single Row Select operation HQL/ JPQL (Scalar query) Multiple columns
	@Query("SELECT cno, cname FROM Customer WHERE cname= :name")
	//List<Object[]> getDataValueByName(String name);
	Object getDataValueByName(String name);
	
	//Single Row Select operation HQL/ JPQL (Scalar query) single columns
	@Query("SELECT billAmount FROM Customer WHERE cname= :name")
	Object getBillAmountByName(String name);

	//Select operation Aggregate functions
	@Query("SELECT MAX(billAmount) FROM Customer")
	Double findMaxBillAmount();

	//Select operation Aggregate functions
	@Query("SELECT MAX(billAmount), SUM(billAmount), AVG(billAmount), COUNT(*) FROM Customer")
	Object findAggregateResults();

	
	
	//Update operation
	@Modifying
	@Query("UPDATE Customer SET billAmount=billAmount+:extraAmount WHERE cadd=:city")
	int modifyCustomeByCity(String city, double extraAmount);
	
	//Delete operation
	@Modifying
	@Query("DELETE Customer WHERE cadd IS NULL")
	int deleteCustomeIfCadIsNull();
	
	//Execute Native SQL select queries
	//@Query(nativeQuery = true, value = "SELECT CNO, CNAME, CADD, BILL_AMOUNT FROM CUSTOMER WHERE CADD=?")
	//@Query(nativeQuery = true, value = "SELECT CNO, CNAME, CADD, BILL_AMOUNT FROM CUSTOMER WHERE CADD=?1")
	@Query(nativeQuery = true, value = "SELECT CNO, CNAME, CADD, BILL_AMOUNT FROM CUSTOMER WHERE CADD=:address")
	Iterable<Customer> getCustomersByAddress(String address);
	
	//get System date
	@Query(nativeQuery = true, value="SELECT SYSDATE FROM DUAL")
	java.util.Date getSystemDate();

	//Insert operation
	@Query(nativeQuery = true, value="INSERT INTO CUSTOMER VALUES (CNO_SEQ.NEXTVAL, ?, ?,?)")
	@Modifying
	int insertCustomer(double billAmount, String address, String name);
	
	
	//Calling Procedure and funcation
	//@Query(nativeQuery = true, value = "{call GET_CUSTOMERS_BY_ADDS(?)}")
	//@Query(nativeQuery = true, value = "{call GET_CUSTOMERS_BY_ADDS(?1)}")
	@Query(nativeQuery = true, value = "{call GET_CUSTOMERS_BY_ADDS(:addrs)}")
	Iterable<Customer> featchCustomerDataByAddrs(String addrs);
	
}	
