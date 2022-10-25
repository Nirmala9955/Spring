package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	
	@Autowired
	private CustomerRepo custRepo;
	
	@Override
	public String registerCustomer(CustomerDTO dto) {
		System.out.println(custRepo.getClass()+" : "+Arrays.toString(custRepo.getClass().getInterfaces()));
		Customer cust = null;
		//convert dto to entity
		cust = new Customer();
		BeanUtils.copyProperties(dto, cust);
		//use repo
		cust = custRepo.save(cust);
		return cust!=null?"Object is saved with id : "+cust.getCno():"Object is not saved";
	}

	@Override
	public String registerGroupCustomer(List<CustomerDTO> listDTO) {
		List<Customer> listEntities = new ArrayList();
		List<Customer> listEntities1 = null;	
		String ids = new String();
		//convert dto to entity
		listDTO.forEach(dto -> {
			Customer cust = new Customer();
			BeanUtils.copyProperties(dto, cust);
			listEntities.add(cust);
		});
		//user repo 
		listEntities1 = (List<Customer>) custRepo.saveAll(listEntities);
		for (Customer customer : listEntities1) {
			ids = ids+", "+customer.getCno();
		} 
		return listEntities1!=null?"Batch records are inserted with ids "+ids:"Records are not inserted";
	}

	@Override
	public String removeCustomerByID(int id) {
		boolean flag = false;
		//use repo
		flag = custRepo.existsById(id);
		if (flag) 
			custRepo.deleteById(id);
		return flag?"Given Record has deleted":"Record not exist";
	}
	
	@Override
	public String removeGivenCustomers(Iterable<CustomerDTO> itDTO) {
		Iterable<Customer> itEntity = new ArrayList();
		//use repos
		itDTO.forEach(dto-> {
			Customer cust = new Customer();
			BeanUtils.copyProperties(dto, cust);
			((List<Customer>) itEntity).add(cust);
		});
		//use repo
		custRepo.deleteAll(itEntity);
		return "Bulk records are deleted";
	}
	
	@Override
	public Long fetchCustomerCount() {
		//use repo
		return custRepo.count();
	}

	@Override
	public Iterable<CustomerDTO> fetchAllCustomer() {
		Iterable<Customer> itEntities = null;
		Iterable<CustomerDTO> itDTO = new ArrayList();
		//use repo
		itEntities = custRepo.findAll();
		//convet entity to dto
		itEntities.forEach(entity->{
			CustomerDTO dto = new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			((List<CustomerDTO>) itDTO).add(dto);
		});
		return itDTO;
	}

	@Override
	public Optional<CustomerDTO> fetchCustomerById(int id) {
		Optional<Customer> optEntity;
		Optional<CustomerDTO> optDTO = null;
		//use repo
		optEntity = custRepo.findById(id);
		
		if (!optEntity.isEmpty()) {
			optDTO = Optional.of(new CustomerDTO());
			BeanUtils.copyProperties(optEntity.get(), optDTO.get());
		} else  {
			optDTO = optDTO.empty();
		}
		return optDTO;
	}
	
}
