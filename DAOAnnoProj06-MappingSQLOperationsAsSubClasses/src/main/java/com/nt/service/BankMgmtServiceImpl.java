package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.BankAccountBO;
import com.nt.dao.IBankDAO;
import com.nt.dto.BankAccountDTO;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService {

	@Autowired
	private IBankDAO dao;
	
	@Override
	public List<BankAccountDTO> fetchBankAccountsByBalanceRange(float start, float end) {
		//use DAO
		List<BankAccountBO> listBO = dao.getBankAccountsByBalanceRange(start, end);
		//convert listBO to listDTO
		List<BankAccountDTO> listDTO = new ArrayList<>();
		listBO.forEach(bo->{
			BankAccountDTO dto = new BankAccountDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public BankAccountDTO fetchBankAccountsByAccNo(long accno) {
		// use dao
		BankAccountBO bo = dao.getBankAccountByAccNo(accno);
		//convert DTO to bo
		BankAccountDTO dto = new BankAccountDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public String addBonusToBankAccountsByBalance(float bonus, float maxBalance) {
		//use dao
		int count = dao.updateBankAccountsWithBonusByBalance(bonus, maxBalance);
		return count==0?"No accounts found for add bonus":count+" No. of records are added with bonus:"+bonus;
	}

}
