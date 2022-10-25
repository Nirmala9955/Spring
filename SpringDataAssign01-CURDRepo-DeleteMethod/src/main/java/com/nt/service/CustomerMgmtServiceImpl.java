package com.nt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	
	@Autowired
	private CustomerRepo custRepo;

	@Override
	public String removeAllCustomer() {
		String result = null;
		//use repo
		if(custRepo.count()!=0) {
			custRepo.deleteAll();
			result = "All records are deleted";
		}
		else
			result = "No record for deletion";
		return result;
	}
	
	
}
