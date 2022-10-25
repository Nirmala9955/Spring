package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nt.bo.BankAccountBO;

@Repository("bankDAO")
public class BankDAOImpl implements IBankDAO {
	
	private static final String GET_ACCOUNT_BY_BAL_RANGE="SELECT ACCNO, HOLDERNAME, BALANCE, STATUS FROM BANK_ACCOUNT WHERE BALANCE>=? AND BALANCE<=?";
	private static final String GET_ACCOUNT_BY_ACCNO="SELECT ACCNO, HOLDERNAME, BALANCE, STATUS FROM BANK_ACCOUNT WHERE ACCNO=?";
	private static final String UPDATE_BONUS_BY_BALANCE="UPDATE BANK_ACCOUNT SET BALANCE=BALANCE+? WHERE BALANCE<?";
	
	BankAccountSelectorByBalRange selector1;
	BankAccountSelectorByAccNo selector2;
	BankAccountUpdatorByBalance updator1;
	
	
	@Autowired
	public BankDAOImpl(DataSource ds) {
		selector1 = new BankAccountSelectorByBalRange(ds, GET_ACCOUNT_BY_BAL_RANGE);
		selector2 = new BankAccountSelectorByAccNo(ds, GET_ACCOUNT_BY_ACCNO);
		updator1 = new BankAccountUpdatorByBalance(ds, UPDATE_BONUS_BY_BALANCE);
	}

	@Override
	public List<BankAccountBO> getBankAccountsByBalanceRange(float start, float end) {
		List<BankAccountBO> listBO = selector1.execute(start, end);
		return listBO;
	}
	
	private static class BankAccountSelectorByBalRange extends MappingSqlQuery<BankAccountBO> {
		
		public BankAccountSelectorByBalRange(DataSource ds, String query) {
			super(ds, query);// gives DS, query to super class
			//register query param (?) with JDBC type
			super.declareParameter(new SqlParameter(Type.FLOAT));
			super.declareParameter(new SqlParameter(Type.FLOAT));
			//make super class complier query
			super.compile();
		}
		
		@Override
		public BankAccountBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			// convert Rs records into BO class object
			BankAccountBO bo = new BankAccountBO();
			bo.setAccNo(rs.getLong(1));
			bo.setHolderName(rs.getString(2));
			bo.setBalance(rs.getFloat(3));
			bo.setStatus(rs.getString(4));
			return bo;
		} //mapRow(-,-)
		
	} //inner class
	
	/*---------------------------------------------*/
	
	@Override
	public BankAccountBO getBankAccountByAccNo(long accno) {
		BankAccountBO bo = selector2.findObject(accno);
		return bo;
	}
	
	private static class BankAccountSelectorByAccNo extends MappingSqlQuery<BankAccountBO> {
	
		public BankAccountSelectorByAccNo(DataSource ds, String query) {
			super(ds, query);// gives DS, query to super class
			//register query param (?) with JDBC type
			super.declareParameter(new SqlParameter(Type.LONG));
			//make super class complier query
			super.compile();
		}
		
		@Override
		public BankAccountBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			// convert Rs records into BO class object
			BankAccountBO bo = new BankAccountBO();
			bo.setAccNo(rs.getLong(1));
			bo.setHolderName(rs.getString(2));
			bo.setBalance(rs.getFloat(3));
			bo.setStatus(rs.getString(4));
			return bo;
		} //mapRow(-,-)
		
	} //inner class

	//----------------------------------------------
	
	@Override
	public int updateBankAccountsWithBonusByBalance(float bonus, float maxBalance) {
		int count = updator1.update(bonus, maxBalance);
		return count;
	}
	
	private static class BankAccountUpdatorByBalance extends SqlUpdate {
		
		public BankAccountUpdatorByBalance(DataSource ds, String query) {
			super(ds, query);// gives DS, query to super class
			//register query param (?) with JDBC type
			super.declareParameter(new SqlParameter(Type.FLOAT));
			super.declareParameter(new SqlParameter(Type.FLOAT));
			//make super class complier query
			super.compile();
		}
		
	} //inner class
	
} //outer class