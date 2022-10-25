package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDAO")
public class BankDAOImpl implements IBankDAO {
	
	private static final String WITHDRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACCOUNTNO=?";
	private static final String DEPOSIT_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACCOUNTNO=?";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int withdraw(long acccountNo, double amount) {
		int count=0;
		count = jt.update(WITHDRAW_QUERY, amount, acccountNo);
		return count;
	}

	@Override
	public int deposit(long acccountNo, double amount) {
		int count=0;
		count = jt.update(DEPOSIT_QUERY, amount, acccountNo);
		return count;
	}

}
