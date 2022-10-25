package com.nt.beans;

import java.io.File;
import java.net.URL;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class PersonInfo {
	private Long aadharNo;
	private String pname;
	private String[] addresses;
	private float salary;
	private File photoPath;
	private Currency countryCurrency;
	private Date dob;
	private Class javaClass;
	private Class[] javaClasses;
	private URL fbUrl;
	private Locale currentLocale;	
	private TimeZone timeZone;
	private Properties props; 
}
