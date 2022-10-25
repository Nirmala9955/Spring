package com.nt.service;

import com.nt.dao.IBankDAO;

public class BankMgmtServiceImpl implements IBankMgmtService {

	private IBankDAO dao;
	
	public BankMgmtServiceImpl(IBankDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean transferMoney(long srcAccNo, long desAccNo, double amount) {
		boolean flag = false;
		/*try {
			Thread.sleep(20000);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		int count1 = dao.withdraw(srcAccNo, amount);
		int count2 = dao.deposit(desAccNo, amount);
		if (count1==0||count2==0)
			throw new RuntimeException("Problem in Money transfering");
		else 
			flag = true;
		return flag;
	}

}
