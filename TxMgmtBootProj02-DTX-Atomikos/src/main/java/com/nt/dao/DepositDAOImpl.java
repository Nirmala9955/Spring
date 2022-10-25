package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("depositeDAO")
public class DepositDAOImpl implements IDepositDAO {
	
	private static final String DEPOSIT_QUERY = "UPDATE DTX_BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=?";
	
	@Autowired
	@Qualifier("mysqlTemplate")
	private JdbcTemplate mysqlJT;
	
	@Override
	public int deposit(long accno, double amount) {
		int count=0;
		count = mysqlJT.update(DEPOSIT_QUERY, amount, accno);
		return count;
	}

}
