package com.nt.component;

public class Test {

	private int a, b;

	static {
		System.out.println("Test.static block");
	}

	public Test() {
		System.out.println("Test.Test()");
	}

	public Test(int a, int b) {
		System.out.println("Test.Test(-,-)");
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "Test [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
