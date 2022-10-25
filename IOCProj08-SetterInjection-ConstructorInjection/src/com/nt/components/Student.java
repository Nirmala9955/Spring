package com.nt.components;

public class Student {

	private int sno;
	private String sname;
	private String sadd;
	private float avg;

	public Student() {
		System.out.println("Student : Student()");
	}

	public Student(int sno, String sname, String sadd, float avg) {
		System.out.println("Student : Student(-,-,-,-)");
		this.sno = sno;
		this.sname = sname;
		this.sadd = sadd;
		this.avg = avg;
	}

	public void setSno(int sno) {
		System.out.println("Student : setSno()");
		this.sno = sno;
	}

	public void setSname(String sname) {
		System.out.println("Student : setSname()");
		this.sname = sname;
	}

	public void setSadd(String sadd) {
		System.out.println("Student : setSadd()");
		this.sadd = sadd;
	}

	public void setAvg(float avg) {
		System.out.println("Student : setAvg()");
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", avg=" + avg + "]";
	}

}
