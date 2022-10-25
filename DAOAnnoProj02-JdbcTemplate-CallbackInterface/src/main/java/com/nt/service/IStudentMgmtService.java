package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface IStudentMgmtService {
	public StudentDTO fetchStudentById(int sno);
	public List<StudentDTO> fetchStudentsByCities(String city1,String city2, String city3);
}	
