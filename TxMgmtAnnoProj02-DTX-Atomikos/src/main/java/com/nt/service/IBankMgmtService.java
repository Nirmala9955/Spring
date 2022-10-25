package com.nt.service;

public interface IBankMgmtService {
	public String transferMoney(long srcAccno, long destAccno, double amount);
}
