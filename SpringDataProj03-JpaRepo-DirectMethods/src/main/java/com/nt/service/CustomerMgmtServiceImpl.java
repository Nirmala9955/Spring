package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	
	@Autowired
	private CustomerRepo custRepo;

	@Override
	public List<CustomerDTO> fetchAllRecordsByGivenExampleDTO(CustomerDTO dto) {
		Customer entity = null;
		Example<Customer> example = null;
		List<Customer> listEntity = null;
		List<CustomerDTO> listDTO = new  ArrayList<>();
		//convert DTO to entity
		entity = new Customer();
		BeanUtils.copyProperties(dto, entity);
		//perpare Examplple object
		example = Example.of(entity);
		//use repo
		listEntity = custRepo.findAll(example);
		//covert listEntity to listDTO
		listEntity.forEach(entity1-> {
			CustomerDTO dto1 = new CustomerDTO();
			BeanUtils.copyProperties(entity1, dto1);
			listDTO.add(dto1);
		});
		return listDTO;
	}

	@Override
	public String removeAllCustomer() {
		boolean flag = false;
		// TODO Auto-generated method stub
		if(custRepo.count()>=1) {
			custRepo.deleteAllInBatch();
			flag = true;
		} else {
			flag = false;
		}
		return flag?"All records are deleted":"No records are exist";
	}
}