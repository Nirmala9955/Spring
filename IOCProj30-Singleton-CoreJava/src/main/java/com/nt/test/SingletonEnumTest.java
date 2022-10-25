package com.nt.test;

import com.nt.sdp.Printer1;

public class SingletonEnumTest {

	public static void main(String[] args) {
		Printer1 printer1 = null, printer2 = null;
		printer1 = Printer1.INSTANCE;
		printer2 = Printer1.INSTANCE;
		System.out.println(printer1.hashCode()+"..."+printer2.hashCode());
		System.out.println("is printer1 = printer2 ? "+(printer1==printer2));
		System.out.println("------------------------------");
		printer1.printData("Hello!");
		printer2.printData("how are you?");
		Printer1.INSTANCE.printData("Where are you?");
	}

}
