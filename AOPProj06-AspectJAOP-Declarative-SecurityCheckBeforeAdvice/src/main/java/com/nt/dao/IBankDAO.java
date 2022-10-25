package com.nt.dao;

public interface IBankDAO {
	public int withdraw(long acccountNo, double amount);
	public int deposit(long acccountNo, double amount);
}
