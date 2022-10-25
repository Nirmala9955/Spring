package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.FilmIndustryBO;

public class FilmIndustryDAOImpl implements FilmIndustryDAO {

	private DataSource ds;
	
	private static final String GET_FILMINDUSTRY_DETAILS_BY_ROLE = "SELECT NAME, NICKNAME, PROFESSION, AGE, HEIGHT, DEBUT FROM FILM_INDUSTRY WHERE PROFESSION=?";

	public FilmIndustryDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<FilmIndustryBO> getFilmIndustrysByProfession(String profession) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FilmIndustryBO> listBO = null; 
		try {
			// get Connection
			con = ds.getConnection();
			// create prepared
			ps = con.prepareStatement(GET_FILMINDUSTRY_DETAILS_BY_ROLE);
			// set the value to query param
			ps.setString(1, profession);
			// execute the query
			rs = ps.executeQuery();
			//Create BO object
			listBO = new ArrayList<>();
			while (rs.next()) {
				// Create BO object
				FilmIndustryBO bo = new FilmIndustryBO();
				bo.setName(rs.getString(1));
				bo.setNickName(rs.getString(2));
				bo.setProfession(rs.getString(3));
				bo.setAge(rs.getInt(4));
				bo.setHeight(rs.getFloat(5));
				bo.setDebut(rs.getString(6));
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
