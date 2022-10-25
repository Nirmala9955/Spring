package com.nt.beans;

import java.util.Date;
import java.util.Set;

public class ContactsInfo {
	//bean properties
	private Set<Long> phoneNumber;
	private Set<Date> dates;
	
	public ContactsInfo(Set<Long> phoneNumber, Set<Date> dates) {
		System.out.println(phoneNumber.getClass()+"\n"+dates.getClass());
		this.phoneNumber = phoneNumber;
		this.dates = dates;
	}

	@Override
	public String toString() {
		return "ContactsInfo [phoneNumber=" + phoneNumber + "\ndates=" + dates + "]";
	}
	
}
