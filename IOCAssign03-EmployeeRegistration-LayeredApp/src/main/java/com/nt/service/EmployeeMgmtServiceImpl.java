package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	private EmployeeDAO dao;

	public EmployeeMgmtServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public String calculatNetGrossSalary(EmployeeDTO dto) throws Exception {
		float houseRentAllowance = 7000, transportAllowance = 9345, fBPAllowance = 16000, statutoryBonus = 1645;
		float incomeTax = dto.getBasicSalary()*0.03f, providentFund = 2300, healtInsurance=2000; 
		float grossSalary = 0.0f;
		float netSalary = 0.0f;
		EmployeeBO bo = null;
		int count = 0;
		//calculat gross and net salary
		grossSalary = dto.getBasicSalary() + houseRentAllowance + transportAllowance + fBPAllowance + statutoryBonus;
		netSalary = grossSalary - (incomeTax+providentFund+healtInsurance);
		//Prepare BO
		bo = new EmployeeBO();
		bo.setEmpName(dto.getEmpName());
		bo.setEmpAddress(dto.getEmpAddress());
		bo.setDesg(dto.getDesg());
		bo.setBasicSalary(dto.getBasicSalary());
		bo.setNetSalary(netSalary);
		bo.setGrossSalary(grossSalary);
		//use DAO
		count = dao.insert(bo);
		if (count==0)
			return "Employee registration failed, try again!";
		else 
			return "Employee registration successed\nAnd your Gross Salary is : "+grossSalary+"\nand Net Salary is : "+netSalary;
	}

}
