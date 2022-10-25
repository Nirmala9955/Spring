package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Repository("mysqlCustDAO")
public class MySQLCustomerDAOImpl implements CustomerDAO {
	
	private static final String CUSTOMER_INSERT_QUERY = "INSERT INTO CUSTOMER(CNAME, CADD, PAMT, INTERAMT) VALUES(?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int insert(CustomerBO bo) throws Exception {
		int count = jt.update(CUSTOMER_INSERT_QUERY, bo.getCname(), bo.getCadd(), bo.getPAmnt(), bo.getInterAmt());
		return count;
	}
	
}
