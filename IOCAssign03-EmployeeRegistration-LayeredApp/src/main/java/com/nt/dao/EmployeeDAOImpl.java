package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String EMPLOYEE_INSERT_QUERY = "INSERT INTO EMPLOYEE_DETAILS VALUES (EMP_ID_SEQ.NEXTVAL,?,?,?,?,?,?)";
	private DataSource ds;
	
	public EmployeeDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public int insert(EmployeeBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		//get JDBC connection pool object
		con = ds.getConnection();
		//create prepared statement object
		ps = con.prepareStatement(EMPLOYEE_INSERT_QUERY);
		//set the value to query param 
		ps.setString(1, bo.getEmpName());
		ps.setString(2, bo.getEmpAddress());
		ps.setString(3, bo.getDesg());
		ps.setFloat(4, bo.getBasicSalary());
		ps.setFloat(5, bo.getNetSalary());
		ps.setFloat(6, bo.getGrossSalary());
		//execute query
		count = ps.executeUpdate();
		//close JDBC objects
		ps.close();
		con.close();
		return count;
	}

}
