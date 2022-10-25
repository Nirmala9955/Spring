package com.nt.service;

import com.nt.dto.CustomerDTO;

public interface CustomerMgmtService {
	public Iterable<CustomerDTO> fetchAllRecordsSortByProprty(boolean asc, String propertie);
	public Iterable<CustomerDTO> fetchAllRecordsSortByProprties(boolean asc, String... properties);
	public Iterable<CustomerDTO> fetchRecordsByPageNoAndSize(int pageNo, int pageSize);
	public void fetchRecordByPagination(int pageSize);
}
