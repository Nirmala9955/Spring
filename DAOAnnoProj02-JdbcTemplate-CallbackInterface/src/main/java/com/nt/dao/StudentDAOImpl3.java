package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

//@Repository("studDAO")
public class StudentDAOImpl3 implements IStudentDAO {
	
	private static final String GET_STUDENT_BY_ID = "SELECT SNO, SNAME, ADDRESS, AVG FROM STUDENT WHERE SNO=?";
	private static final String GET_STUDENTS_BY_CITIES = "SELECT SNO, SNAME, ADDRESS, AVG FROM STUDENT WHERE ADDRESS IN(?, ?, ?)";

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public StudentBO getStudentByNo(int sno) {
		return jt.queryForObject(GET_STUDENT_BY_ID, new BeanPropertyRowMapper<>(StudentBO.class), sno);
	}

	@Override
	public List<StudentBO> getStudentsByCities(String city1, String city2, String city3) {
		BeanPropertyRowMapper<StudentBO> bprm  = null;
		//create BeanPropertyRowMapper class object that helps to copy each record into one BO class object
		bprm = new BeanPropertyRowMapper<>(StudentBO.class);
		return jt.query(GET_STUDENTS_BY_CITIES, new RowMapperResultSetExtractor<StudentBO>(bprm), city1, city2, city3);
	}
	@Override
	public List<StudentBO> getStudentsByCities1(String city1, String city2, String city3) {
		// TODO Auto-generated method stub
		return null;
	}


}
