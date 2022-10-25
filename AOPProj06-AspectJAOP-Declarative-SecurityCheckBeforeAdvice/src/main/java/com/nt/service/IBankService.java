package com.nt.service;

public interface IBankService {
	public String withdrawMoney(long acccountNo, double amount);
	public String depositMoney(long acccountNo, double amount);
}
