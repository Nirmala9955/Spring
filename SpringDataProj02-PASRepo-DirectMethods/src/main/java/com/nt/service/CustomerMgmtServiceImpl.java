package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	
	@Autowired
	private CustomerRepo custRepo;

	@Override
	public Iterable<CustomerDTO> fetchAllRecordsSortByProprty(boolean asc, String propertie) {
		Iterable<Customer> itEntity = null;
		Iterable<CustomerDTO> itDTO = new ArrayList();		
		//use repo
		itEntity = custRepo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC, propertie));
		//convert itEnitiy to itDTO
		itEntity.forEach(entity-> {
			CustomerDTO dto = new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			((List) itDTO).add(dto);
		});
		return itDTO;
	}

	@Override
	public Iterable<CustomerDTO> fetchAllRecordsSortByProprties(boolean asc, String... properties) {
		Iterable<Customer> itEntity = null;
		Iterable<CustomerDTO> itDTO = new ArrayList();		
		//use repo
		itEntity = custRepo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC, properties));
		//convert itEnitiy to itDTO
		itEntity.forEach(entity-> {
			CustomerDTO dto = new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			((List) itDTO).add(dto);
		});
		return itDTO;
	}

	@Override
	public Iterable<CustomerDTO> fetchRecordsByPageNoAndSize(int pageNo, int pageSize) {
		Pageable pageable = null;
		Page<Customer> page = null;
		Slice<Customer> slice = null;
		Iterable<Customer> itEntity = null;
		Iterable<CustomerDTO> itDTO = new ArrayList();		
		// Create Pageable object
		pageable = PageRequest.of(pageNo, pageSize);
		//get Page object
		page = custRepo.findAll(pageable);
		//slice = custRepo.findAll(pageable);
		System.out.println(page.getNumber()+" "+page.getNumberOfElements()+" "+page.hasContent()+" "+page.isEmpty()+" "+page.isFirst()+" "+page.getTotalPages()+" "+page.getTotalElements());
		//System.out.println(slice.getNumber()+" "+slice.getNumberOfElements()+" "+slice.hasContent()+" "+slice.isEmpty()+" "+slice.isFirst());
		//convert page object into DTO
		itEntity = page.getContent();
		//itEntity = slice.getContent();
		//convert itEnitiy to itDTO
		itEntity.forEach(entity-> {
			CustomerDTO dto = new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			((List) itDTO).add(dto);
		});
		return itDTO;
	}
	
	@Override
	public void fetchRecordByPagination(int pageSize) {
		long recordsCount = 0;
		long pagesCount = 0;
		Pageable pageable = null;
		Page<Customer> page = null;
		//get total no. of record
		recordsCount = custRepo.count();
		pagesCount = recordsCount/pageSize;
		pagesCount = recordsCount%pageSize==0?pagesCount:pagesCount++;
		//display records through pagenation
		for (int i = 0; i < pagesCount; i++) {
			pageable = PageRequest.of(i, pageSize);
			page = custRepo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("Page "+(i+1)+" of "+page.getTotalPages());
		}
	}
}