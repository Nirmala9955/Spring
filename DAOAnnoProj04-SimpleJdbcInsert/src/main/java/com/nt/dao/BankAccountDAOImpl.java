package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.BankAccountBO;

@Repository("accDAO")
public class BankAccountDAOImpl implements IBankAccountDAO {

	@Autowired
	private SimpleJdbcInsert sji;

	/*	@Override
		public int register(BankAccountBO bo) {
			//prepare Map object having columns and values
			Map<String, Object> map = Map.of("accno", bo.getAccno(), "holderName", bo.getHolderName(), "balance", bo.getBalance(), "status", bo.getStatus());
			//set db table name
			sji.setTableName("BANK_ACCOUNT");
			//execute query by generating the query dynamically
			int count = sji.execute(map);
			return count;
		}*/

	
	@Override
	public int register(BankAccountBO bo) {
		//prepare BeanPropertySqlParameterSource object having BO object 
		//Here column names must match to BO class property name.
		BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(bo);
		//set DB table name
		sji.setTableName("BANK_ACCOUNT");
		//execute query by generating the query dynamically
		int count = sji.execute(bpsps);
		return count;
	}
	
}
