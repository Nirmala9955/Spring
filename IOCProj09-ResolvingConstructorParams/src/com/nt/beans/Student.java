package com.nt.beans;

public class Student {
		
	private int sno;
	private String sname;
	private String sadd;
	private float total;
	
	public Student(int sno, String sname, String sadd, float total) {
		System.out.println("Student : Student(-,-,-,-)");
		this.sno = sno;
		this.sname = sname;
		this.sadd = sadd;
		this.total = total;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", total=" + total + "]";
	}
		
}
