package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("webService")
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String getWishMessage() {
		LocalDateTime ldt = null;
		int hours = 0;
		//get Calendar class obejct
		ldt = LocalDateTime.now();
		//get hour of the day
		hours = ldt.getHour();
		if (hours<12)
			return "Good Morning";
		else if (hours<16)
			return "Good Afternoon";
		else if (hours<20)
			return "Good Evening";
		else 
			return "Good Night";
	}

}
