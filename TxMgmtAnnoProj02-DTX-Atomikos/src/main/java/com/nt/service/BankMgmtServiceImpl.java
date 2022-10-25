package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IDepositDAO;
import com.nt.dao.IWithdrawDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService {
	
	@Autowired
	private IWithdrawDAO withdrawDAO;
	
	@Autowired
	private IDepositDAO depositDAO;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String transferMoney(long srcAccno, long destAccno, double amount) {
		int count1 = withdrawDAO.withdraw(srcAccno, amount);
		int count2 = depositDAO.deposit(destAccno, amount);
		if (count1==0||count2==0)
			throw new RuntimeException("Problem in Money transfering");
		else 
			return "Money Transffered from "+ srcAccno+" to "+destAccno;
	}

}
