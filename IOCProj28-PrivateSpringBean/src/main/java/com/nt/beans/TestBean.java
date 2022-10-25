package com.nt.beans;

public class TestBean {
	
	private int a, b;
	
	private TestBean() {
		System.out.println("TestBean : TestBean()");
	}
	
	private TestBean(int a, int b) {
		System.out.println("TestBean : TestBean(-,-)");
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "TestBean [a=" + a + ", b=" + b + "]";
	}
	
	private static class InnerBean {
		private int c;

		public void setC(int c) {
			this.c = c;
		}

		@Override
		public String toString() {
			return "InnerBean [c=" + c + "]";
		}
		
	}
	
}
