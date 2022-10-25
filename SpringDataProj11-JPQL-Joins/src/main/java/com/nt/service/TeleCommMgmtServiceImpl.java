package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repo.PhoneNumberRepo;
import com.nt.repo.UserRepo;

@Service("teleComService")
public class TeleCommMgmtServiceImpl implements TeleCommMgmtService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PhoneNumberRepo phnoRepo;

	@Override
	public List<Object[]> getDataByJoin() {
		//use userREpo
		return userRepo.fetchDataByJoin();
	}

	@Override
	public List<Object[]> getDataByJoinUsingAddress(String address) {
		//use userREpo
		return userRepo.fetchDataByJoinUsingAddress(address);
	}

}
