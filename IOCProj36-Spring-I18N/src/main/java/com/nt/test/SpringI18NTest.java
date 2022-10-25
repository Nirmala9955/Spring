package com.nt.test;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringI18NTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Locale locale = null;
		String cap1 = null, cap2 = null, cap3 = null, cap4 = null;
		//Create AC IoC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//prepare local object having language and country
		locale = new Locale(args[0], args[1]);
		//get messages
		cap1 = ctx.getMessage("btn1.cap", new String[] {"Student"}, "msg1", locale);
		cap2 = ctx.getMessage("btn2.cap", null, locale);
		cap3 = ctx.getMessage("btn3.cap", null, locale);
		cap4 = ctx.getMessage("btn4.cap", null, locale);
		System.out.println(cap1+" "+cap2+" "+cap3+" "+cap4);
		System.out.println(ctx.getMessage("btn1.cap", null, new Locale("de", "DE")));
	}
}
