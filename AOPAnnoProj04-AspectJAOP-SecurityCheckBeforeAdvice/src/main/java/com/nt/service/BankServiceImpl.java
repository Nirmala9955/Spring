package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IBankDAO;

@Service("bankService")
public class BankServiceImpl implements IBankService {
	
	@Autowired
	private IBankDAO dao;
	
	@Override
	public String withdrawMoney(long acccountNo, double amount) {
		int count = dao.withdraw(acccountNo, amount);
		return count==0?"Money not withdrawn":amount+" money is withdrawn from the account: "+acccountNo;
	}

	@Override
	public String depositMoney(long acccountNo, double amount) {
		int count = dao.deposit(acccountNo, amount);
		return count==0?"Money not deposited":amount+" money is desposited in the account: "+acccountNo;
	}

}
