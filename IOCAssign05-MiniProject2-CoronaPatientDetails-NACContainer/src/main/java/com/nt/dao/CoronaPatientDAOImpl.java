package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.CoronaPatientBO;

public class CoronaPatientDAOImpl implements CoronaPatientDAO {

	private DataSource ds;
	private static final String GET_CORONAPATIENT_DETAILS_BY_ROLE = "SELECT DISTNAME, POSITIVE, RECOVERED, ACTIVE FROM  CORONACASEDETAILSINODISHA WHERE DISTNAME=?";

	public CoronaPatientDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<CoronaPatientBO> getCoronaPatientsByDist(String dist) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CoronaPatientBO> listBO = null; 
		try {
			// get Connection
			con = ds.getConnection();
			// create prepared
			ps = con.prepareStatement(GET_CORONAPATIENT_DETAILS_BY_ROLE);
			// set the value to query param
			ps.setString(1, dist);
			// execute the query
			rs = ps.executeQuery();
			//Create BO object
			listBO = new ArrayList<>();
			while (rs.next()) {
				// Create BO object
				CoronaPatientBO bo = new CoronaPatientBO();
				bo.setDistName(rs.getString(1));
				bo.setPositive(rs.getInt(2));
				bo.setRecovered(rs.getInt(3));
				bo.setActive(rs.getInt(4));
				//add bo object to listBO
				listBO.add(bo);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			try{
				if (rs!=null) 
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
				throw se;
			}
			try{
				if (ps!=null) 
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
				throw se;
			}
			try{
				if (con!=null) 
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
				throw se;
			}
		}
		return listBO;
	}

}
