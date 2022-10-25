package com.nt.sdp;

public class Printer {
	
	private static Printer INSTANCE;
	
	//private constructor
	private Printer() {
		System.out.println("Printer : Printer()");
	}
	
	//static factory method
	public static Printer getInstnnce() {
		if (INSTANCE==null) 
			INSTANCE = new Printer();
		return INSTANCE;
	}
	
	//business logic
	public void printData(String str) {
		System.out.println(str);
	}
}
