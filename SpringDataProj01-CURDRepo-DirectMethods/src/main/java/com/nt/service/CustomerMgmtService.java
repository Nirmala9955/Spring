package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.CustomerDTO;

public interface CustomerMgmtService {
	public String registerCustomer(CustomerDTO dto);
	public String registerGroupCustomer(List<CustomerDTO> listDTO);
	public String removeCustomerByID(int id);
	public String removeGivenCustomers(Iterable<CustomerDTO> itDTO);
	public Long fetchCustomerCount();
	public Iterable<CustomerDTO> fetchAllCustomer();
	public Optional<CustomerDTO> fetchCustomerById(int id);
}
