package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dao.IStudentDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;

@Service("clgService")
public abstract class CollegeMgmtServiceImpl implements ICollegeMgmtService {
	
	@Autowired
	private IStudentDAO stuDAO;
	
	@Autowired
	private IEmployeeDAO empDAO;
	
	@Lookup
	public abstract StudentBO getStudentBO();

	@Lookup
	public abstract EmployeeBO getEmployeeBO();
	
	@Override
	public String enrollStudent(StudentDTO dto) throws Exception {
		int total=0;
		float avg=0.0f;
		StudentBO bo = null;
		int count=0;
		//calculate total and avg
		total = dto.getM1()+dto.getM2()+dto.getM3();
		avg = total/3;
		//get StudentBO Object
		bo = getStudentBO();
		//Copy DTO object to BO
		BeanUtils.copyProperties(dto, bo);
		bo.setTotal(total);
		bo.setAvg(avg);
		//use DAO
		count = stuDAO.registerStudent(bo);
		return (count==0)?"Student is not registered":"Student is registered";
	}

	@Override
	public String enrollEmployee(EmployeeDTO dto) throws Exception {
		float grossSalary=0.0f, netSalary;
		EmployeeBO bo = null;
		int count=0;
		//calculate gross and net salary
		grossSalary=(float) ((dto.getSalary()+(dto.getSalary()*0.4)));
		netSalary= (float) ((grossSalary - (grossSalary*0.2)));
		//get StudentBO Object
		bo = getEmployeeBO();
		//Copy DTO object to BO
		BeanUtils.copyProperties(dto, bo);
		bo.setGrossSalary(grossSalary);
		bo.setNetSalary(netSalary);
		//use DAO
		count = empDAO.registerEmployee(bo);
		return (count==0)?"Employee is not registered":"Employee is registered";
	}

}
