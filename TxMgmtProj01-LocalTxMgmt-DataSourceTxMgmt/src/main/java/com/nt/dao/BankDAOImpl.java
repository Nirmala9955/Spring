package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImpl implements IBankDAO {
	
	private static final String WITHDRAW_QUERY = "UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACCOUNTNO=?";
	private static final String DEPOSIT_QUERY = "UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACCOUNTNO=?";

	private JdbcTemplate jt;
	
	public BankDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int deposit(long accNo, double amount) {
		int count = jt.update(DEPOSIT_QUERY, amount, accNo);
		return count;
	}
	
	@Override
	public int withdraw(long accNo, double amount) {
		int count = jt.update(WITHDRAW_QUERY, amount, accNo);
		return count;
	}
	
}
