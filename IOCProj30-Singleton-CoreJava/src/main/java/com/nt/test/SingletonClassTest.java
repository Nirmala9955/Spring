package com.nt.test;

import com.nt.sdp.Printer;

public class SingletonClassTest {

	public static void main(String[] args) {
		Printer printer1 = null, printer2 = null;
		printer1 = Printer.getInstnnce();
		printer2 = Printer.getInstnnce();
		System.out.println(printer1.hashCode()+"..."+printer2.hashCode());
		System.out.println("is printer1 = printer2 ? "+(printer1==printer2));
		System.out.println("------------------------------");
		printer1.printData("Hello!");
		printer2.printData("how are you?");
	}

}
