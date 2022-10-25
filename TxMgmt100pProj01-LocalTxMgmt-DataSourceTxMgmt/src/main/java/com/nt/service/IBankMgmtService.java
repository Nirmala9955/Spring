package com.nt.service;

public interface IBankMgmtService {
	public boolean transferMoney(long srcAccNo, long desAccNo, double amount);
}
