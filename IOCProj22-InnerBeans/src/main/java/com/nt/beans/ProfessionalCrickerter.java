package com.nt.beans;

public class ProfessionalCrickerter {
	
	private String name;
	private CricketBat bat;
	
	public ProfessionalCrickerter(String name, CricketBat bat) {
		System.out.println("ProfessionalCricketer :ProfessionalCricketer()");
		this.name = name;
		this.bat = bat;
	}

	public String batting() {
		int runs = 0;
		runs = bat.scoreRuns();
		return "Professional Crickter Mr. "+name+" has scored "+runs+" run.";
	}
	
}
