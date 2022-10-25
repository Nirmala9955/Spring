package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IBankDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService {
	
	@Autowired
	private IBankDAO dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, timeout = 10)
	public boolean transferMoney(long srcAccNo, long desAccNo, double amount) {
		boolean flag = false;
		int count1 = dao.withdraw(srcAccNo, amount);
		int count2 = dao.deposit(desAccNo, amount);
		if (count1==0||count2==0)
			throw new RuntimeException("Problem in Money transfering");
		else 
			flag = true;
		return flag;
	}

}
