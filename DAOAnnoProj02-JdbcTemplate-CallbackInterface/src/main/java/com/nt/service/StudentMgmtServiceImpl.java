package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.IStudentDAO;
import com.nt.dto.StudentDTO;

@Service("studService")
public class StudentMgmtServiceImpl implements IStudentMgmtService {
	
	@Autowired
	private IStudentDAO dao; 
	
	@Override
	public StudentDTO fetchStudentById(int sno) {
		StudentBO bo = null;
		StudentDTO dto = null;
		//use DAO
		bo = dao.getStudentByNo(sno);
		//copy BO to DTO
		dto = new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public List<StudentDTO> fetchStudentsByCities(String city1, String city2, String city3) {
		List<StudentBO> listBO = null;
		//use DAO
		//listBO = dao.getStudentsByCities1(city1, city2, city3);
		listBO = dao.getStudentsByCities1(city1, city2, city3);
		//copy listBO to list DTO
		List<StudentDTO> listDTO = new ArrayList<>();
		listBO.forEach(bo->{
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

}
