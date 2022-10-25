package com.nt.service;

import com.nt.dao.IBankDAO;

public class BankServiceImpl implements IBankService {
	
	private IBankDAO dao;
	
	public BankServiceImpl(IBankDAO dao) {
		this.dao = dao;
	}

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
