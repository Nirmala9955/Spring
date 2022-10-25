package com.nt.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NTest {

	public static void main(String[] args) {
		Locale locale = null;
		ResourceBundle bundle = null;
		//prepare local object having language and country
		locale = new Locale(args[0], args[1]);
		//create ResourceBundle object having Locale object
		bundle = ResourceBundle.getBundle("com/nt/commons/App", locale);
		//read and display values
		System.out.println(bundle.getString("btn1.cap")+" "+bundle.getString("btn2.cap")+" "+bundle.getString("btn3.cap")+" "+bundle.getString("btn4.cap"));
	}
}
