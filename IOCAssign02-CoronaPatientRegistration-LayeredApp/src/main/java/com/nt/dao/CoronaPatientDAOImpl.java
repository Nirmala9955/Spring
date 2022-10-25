package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.CoronaPatientBO;

public class CoronaPatientDAOImpl implements CoronaPatientDAO {
	
	private static final String CORONA_PATIENT_INSERT_QUERY = "INSERT INTO CORONA_PATIENT VALUES (PATIENT_ID_SEQ.NEXTVAL,?,?,?,?,?,?)"; 
	private DataSource ds;
	
	public CoronaPatientDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public int insert(CoronaPatientBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		//get JDBC Connection pool object
		con = ds.getConnection();
		//Create prepared statement object
		ps = con.prepareStatement(CORONA_PATIENT_INSERT_QUERY);
		//set the value to query para
		ps.setString(1, bo.getPatientName());
		ps.setString(2, bo.getPatientAddress());
		ps.setInt(3, bo.getPatientAge());
		ps.setString(4, bo.getHospitalName());
		ps.setInt(5, bo.getNoOfDays());
		ps.setFloat(6, bo.getBillAmount());
		//execute the query
		count = ps.executeUpdate();
		//close the JDBC object
		ps.close();
		con.close();
		return count;
	}

}
