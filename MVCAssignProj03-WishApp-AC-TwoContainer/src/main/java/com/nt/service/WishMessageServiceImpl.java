package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements WishMessageService {

	@Override
	public String getWishMessage() {
		Calendar calendar = null;
		int hours = 0;
		//get Calendar class obejct
		calendar = Calendar.getInstance();
		//get hour of the day
		hours = calendar.HOUR_OF_DAY;
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
