package com.nt.beans;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class UniversityInfo {
	
	private Map<Long, String> facultyDetails;
	private Map<String, Date> dates;
	private Properties fruits;
	
	public void setFacultyDetails(Map<Long, String> facultyDetails) {
		System.out.println(facultyDetails.getClass());
		this.facultyDetails = facultyDetails;
	}
	public void setDates(Map<String, Date> dates) {
		System.out.println(dates.getClass());
		this.dates = dates;
	}
	public void setFruits(Properties fruits) {
		System.out.println(fruits.getClass());
		this.fruits = fruits;
	}

	@Override
	public String toString() {
		return "UniversityInfo [facultyDetails=" + facultyDetails + "\ndates=" + dates + "\nfruits=" + fruits + "]";
	}
	
}
