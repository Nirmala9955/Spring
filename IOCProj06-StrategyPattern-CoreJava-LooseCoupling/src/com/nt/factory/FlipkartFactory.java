package com.nt.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.nt.components.Courier;
import com.nt.components.Flipkart;

public class FlipkartFactory {
	
	private static Properties props;
	
	static {
		InputStream is = null;
		try {
			//load Properties file using InputStreams
			is = new FileInputStream("src/com/nt/commons/info.properties");
			//Load properties file into java.util.Properties object
			props = new Properties();
			props.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Flipkart getInstane() throws Exception {
		Courier courier=null;
		Flipkart fpkt=null;
		//get Dependent class object and create	class object
		courier = (Courier) Class.forName(props.getProperty("sdp.dependent")).newInstance();
		//create target class object
		fpkt=new Flipkart();
		//assign dependent class object to target class object
		fpkt.setCourier(courier);
		return fpkt;
	}

}
