package com.nt.beans;

import java.util.Date;
import java.util.List;

public class College {
	
	//bean properties
	private List<String> studName;
	private List<Date> joinDate;
	
	public void setStudName(List<String> studName) {
		System.out.println(studName.getClass());
		this.studName = studName;
	}
	public void setJoinDate(List<Date> joinDate) {
		System.out.println(joinDate.getClass());
		this.joinDate = joinDate;
	}
	
	@Override
	public String toString() {
		return "College [studName=" + studName + "\njoinDate=" + joinDate + "]";
	}
	
	
}
