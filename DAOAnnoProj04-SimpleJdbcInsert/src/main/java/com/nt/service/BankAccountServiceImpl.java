package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.BankAccountBO;
import com.nt.dao.IBankAccountDAO;
import com.nt.dto.BankAccountDTO;

@Service("accService")
public class BankAccountServiceImpl implements IBankAccountService {
	
	@Autowired
	private IBankAccountDAO dao;

	@Override
	public String createBankAccount(BankAccountDTO dto) {
		BankAccountBO bo = new BankAccountBO();
		//convert DTO to BO
		BeanUtils.copyProperties(dto, bo);
		//use dao 
		int count = dao.register(bo);
		return count==1?dto.getHolderName()+" your acccount has created":dto.getHolderName()+" your acccount has not created yet";
	}

}
