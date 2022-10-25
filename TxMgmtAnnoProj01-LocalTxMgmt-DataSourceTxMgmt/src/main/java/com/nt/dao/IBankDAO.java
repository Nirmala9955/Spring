package com.nt.dao;

public interface IBankDAO {
	public int withdraw(long accNo, double amount);
	public int deposit(long accNo, double amount);
}
