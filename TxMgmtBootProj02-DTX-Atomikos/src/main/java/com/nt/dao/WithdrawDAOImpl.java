package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("withdrawDAO")
public class WithdrawDAOImpl implements IWithdrawDAO {

	private static final String WITHDRAW_QUERY = "UPDATE DTX_BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACCNO=?";
	
	@Autowired
	@Qualifier("oracleTemplate")
	private JdbcTemplate oraJT;
	
	@Override
	public int withdraw(long accno, double amount) {
		int count=0;
		count = oraJT.update(WITHDRAW_QUERY, amount, accno);
		return count;
	}

}
