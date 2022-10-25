package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("studDAO")
public class StudentDAOImpl2 implements IStudentDAO {
	
	private static final String GET_STUDENT_BY_ID = "SELECT SNO, SNAME, ADDRESS, AVG FROM STUDENT WHERE SNO=?";
	private static final String GET_STUDENTS_BY_CITIES = "SELECT SNO, SNAME, ADDRESS, AVG FROM STUDENT WHERE ADDRESS IN(?, ?, ?)";

	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public StudentBO getStudentByNo(int sno) {
		return jt.queryForObject(GET_STUDENT_BY_ID, (rs, rowNum) -> {
				StudentBO bo = null;
				//convert RS record into student BO class object
				bo = new StudentBO();
				bo.setSno(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setAddress(rs.getString(3));
				bo.setAvg(rs.getFloat(4));
				return bo;
		}, sno);
	}

	@Override
	public List<StudentBO> getStudentsByCities(String city1, String city2, String city3) {
		return jt.query(GET_STUDENTS_BY_CITIES, rs->{
			List<StudentBO> listBO = new ArrayList<>();
			//copy Rs object records to listBO
			while (rs.next()) {
				StudentBO bo = new StudentBO();
				bo.setSno(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setAddress(rs.getString(3));
				bo.setAvg(rs.getFloat(4));
				listBO.add(bo);
			}
			return listBO;
		}, city1, city2, city3);
	}

	@Override
	public List<StudentBO> getStudentsByCities1(String city1, String city2, String city3) {
		List<StudentBO> listBO = new ArrayList();
		jt.query(GET_STUDENTS_BY_CITIES,  rs -> {
				//convert RS record into BO 
				StudentBO bo = new StudentBO();
				bo.setSno(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setAddress(rs.getString(3));
				bo.setAvg(rs.getFloat(4));
				listBO.add(bo);
			}, city1, city2, city3);
		return listBO;
	}

}
	
