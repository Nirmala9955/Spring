package com.nt.service;

import java.util.List;

public interface TeleCommMgmtService {
		
	public List<Object[]> getDataByJoin();
	
	public List<Object[]> getDataByJoinUsingAddress(String address);
	
}
	