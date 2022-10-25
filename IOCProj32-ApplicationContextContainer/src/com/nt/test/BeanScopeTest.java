package com.nt.test;
	
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.sdp.Printer;

public class BeanScopeTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		//create Application Context IoC container
		ctx = new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
		WishMessageGenerator generator = null;
		Printer printer = null;
		// create object
		generator = ctx.getBean("wmg", WishMessageGenerator.class);
		System.out.println(generator.generateWishMessage("Raja"));
		System.out.println("------------------------------------");
		printer = ctx.getBean("printerBean", Printer.class);
		printer.printData("Hello");

		//close container
		((FileSystemXmlApplicationContext)ctx).close();
	}

}
