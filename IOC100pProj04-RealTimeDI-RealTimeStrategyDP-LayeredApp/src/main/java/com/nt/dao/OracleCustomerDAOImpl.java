package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Repository("oracleCustDAO")
public final class OracleCustomerDAOImpl implements CustomerDAO {
	
	private static final String CUSTOMER_INSERT_QUERY = "INSERT INTO CUSTOMER_DB VALUES(CNO_SEQ.NEXTVAL,?,?,?,?)";
	
	@Autowired
	@Qualifier("oracleHKDS")
	private DataSource ds;

	@Override
	public int insert(CustomerBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		//get JDBC connection pool object
		con = ds.getConnection();
		//Create prepareStatement object
		ps = con.prepareStatement(CUSTOMER_INSERT_QUERY);
		//set the value to query param
		ps.setString(1, bo.getCname());
		ps.setString(2, bo.getCadd());
		ps.setFloat(3, bo.getpAmnt());
		ps.setFloat(4, bo.getInterAmt());
		//execute the query
		count = ps.executeUpdate();
		//close JDBC objects
		ps.close();
		con.close();
		return count;
	}
	
}
