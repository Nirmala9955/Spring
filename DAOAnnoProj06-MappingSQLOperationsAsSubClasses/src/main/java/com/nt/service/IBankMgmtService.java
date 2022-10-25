package com.nt.service;

import java.util.List;

import com.nt.dto.BankAccountDTO;

public interface IBankMgmtService {
	public List<BankAccountDTO> fetchBankAccountsByBalanceRange(float start, float end);
	public BankAccountDTO fetchBankAccountsByAccNo(long accno);
	public String addBonusToBankAccountsByBalance(float bonus, float maxBalance);
}
