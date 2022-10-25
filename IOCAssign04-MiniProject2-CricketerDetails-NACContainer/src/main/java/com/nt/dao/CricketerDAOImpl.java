package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.CricketerBO;
import com.nt.bo.CricketerBO;

public class CricketerDAOImpl implements CricketerDAO {

	private DataSource ds;
	private static final String GET_CRICKETER_DETAILS_BY_ROLE = "SELECT CRICKETERID, CRICKETERNAME, AGE, ROLE, MATCHES, HS FROM  CRICKETERDETAILS WHERE ROLE=?";

	public CricketerDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<CricketerBO> getCricketersByRole(String role) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CricketerBO> listBO = null; 
		try {
			// get Connection
			con = ds.getConnection();
			// create prepared
			ps = con.prepareStatement(GET_CRICKETER_DETAILS_BY_ROLE);
			// set the value to query param
			ps.setString(1, role);
			// execute the query
			rs = ps.executeQuery();
			//Create BO object
			listBO = new ArrayList<>();
			while (rs.next()) {
				// Create BO object
				CricketerBO bo = new CricketerBO();
				bo.setCricketerId(rs.getInt(1));
				bo.setCricketerName(rs.getString(2));
				bo.setAge(rs.getInt(3));
				bo.setRole(rs.getString(4));
				bo.setMatches(rs.getInt(5));
				bo.setHs(rs.getInt(5));
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
