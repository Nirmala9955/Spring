package com.nt.beans;

public class Marks {
	
	private float m1, m2, m3;

	public Marks(float m1, float m2, float m3) {
		System.out.println("Marks : Marks(-,-,-)");
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}

	@Override
	public String toString() {
		return "Marks [m1=" + m1 + ", m2=" + m2 + ", m3=" + m3 + "]";
	}
	
}
