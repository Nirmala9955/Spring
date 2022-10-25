package com.nt.beans;

import java.time.LocalDate;

public class ScheduleReminder {
	
	private LocalDate date;

	public ScheduleReminder(LocalDate date) {
		this.date = date;
	}
	
	public String checkReminder() {
		LocalDate sysDate = LocalDate.now();
		if (sysDate.isEqual(date)) 
			return "You have a borad meeting please read on time and attend";
		else 
			return "You dont have any remider today, relax and take rest";
	}
	
}
