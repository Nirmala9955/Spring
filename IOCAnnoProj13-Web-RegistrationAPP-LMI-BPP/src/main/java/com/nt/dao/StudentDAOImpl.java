package com.nt.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("stuDAO")
@Scope("singleton")
public class StudentDAOImpl implements IStudentDAO {

	@Override
	public int registerStudent(StudentBO bo) throws Exception {
		System.out.println("Inserting data to Student DB table having data : "+ bo);
		return 1;
	}

}
