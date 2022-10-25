package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.dto.StudentDTO;

@Service("stuService")
public class StudentMgmtServiceImpl implements IStudentMgmtService {

	public List<StudentDTO> getAllStudent() {
		return List.of(new StudentDTO(101, "Raja", "Hyd", 67.8f),
				new StudentDTO(102, "Ramesh", "MP", 77.8f),
				new StudentDTO(103, "Lokesh", "Delhi", 68.8f),
				new StudentDTO(104, "Hari", "Vizg", 87.8f));
	}

}
