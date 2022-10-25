package com.nt.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("stuDAO")
@Scope("singleton")
public interface IStudentDAO {
	public int registerStudent(StudentBO bo) throws Exception;
}
