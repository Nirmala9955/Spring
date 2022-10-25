package com.nt.dao;

import java.util.List;

import com.nt.bo.StudentBO;

public interface IStudentDAO {
	public StudentBO getStudentByNo(int sno);
	public List<StudentBO> getStudentsByCities(String city1, String city2, String city3);
	public List<StudentBO> getStudentsByCities1(String city1, String city2, String city3);
}
