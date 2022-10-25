package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private DataSource ds;
	
	private static final String GET_EMP_DETAILS_BY_DESG = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE JOB IN (?, ?, ?) ORDER BY JOB";

	@Override
	public List<EmployeeBO> getEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EmployeeBO> listBO = null; 
		try {
			// get Connection
			con = ds.getConnection();
			// create prepared
			ps = con.prepareStatement(GET_EMP_DETAILS_BY_DESG);
			// set the value to query param
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			// execute the query
			rs = ps.executeQuery();
			//Create BO object
			listBO = new ArrayList<>();
			while (rs.next()) {
				// Create BO object
				EmployeeBO bo = new EmployeeBO();
				bo.setEmpno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				bo.setDeptno(rs.getInt(5));
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
