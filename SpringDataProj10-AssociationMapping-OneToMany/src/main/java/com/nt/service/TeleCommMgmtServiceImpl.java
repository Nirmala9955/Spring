package com.nt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.PhoneNumberDTO;
import com.nt.dto.UserDTO;
import com.nt.entity.PhoneNumber;
import com.nt.entity.User;
import com.nt.repo.PhoneNumberRepo;
import com.nt.repo.UserRepo;

@Service("teleComService")
public class TeleCommMgmtServiceImpl implements TeleCommMgmtService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PhoneNumberRepo phnoRepo;
	
	@Override
	public String registerCustomer(UserDTO userDTO) {
		User userEntity = null;
		Set<PhoneNumberDTO> childDTO = null;
		Set<PhoneNumber> childEntity = new HashSet<>();		
		//convert userDTO to userEntity
		userEntity = new User();
		BeanUtils.copyProperties(userDTO, userEntity);
		childDTO = userDTO.getPhones(); 
		childDTO.forEach(phDTO -> {
			PhoneNumber phEntity = new PhoneNumber();
			BeanUtils.copyProperties(phDTO, phEntity);
			childEntity.add(phEntity);
		});
		userEntity.setPhones(childEntity);
		return "Customer is registered having User Id : "+userRepo.save(userEntity).getUserId();
	}

}
