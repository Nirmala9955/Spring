package com.nt.beans;

public class B {
	
	private A a;

	public B(A a) {
		System.out.println("B : B(-)");
		this.a = a;
	}

	@Override
	public String toString() {
		return "B [a]";
	}
	
}
