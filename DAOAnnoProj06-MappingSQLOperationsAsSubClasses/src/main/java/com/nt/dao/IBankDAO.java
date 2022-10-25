package com.nt.dao;

import java.util.List;

import com.nt.bo.BankAccountBO;

public interface IBankDAO {
	public List<BankAccountBO> getBankAccountsByBalanceRange(float start, float end);
	public BankAccountBO getBankAccountByAccNo(long accno);
	public int updateBankAccountsWithBonusByBalance(float bonus, float maxBalance);
}
