package com.nt.test;

import com.nt.components.Flipkart;
import com.nt.factory.FlipkartFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
		Flipkart fpkt = null;
		try {
			fpkt=FlipkartFactory.getInstane();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(fpkt.shopping(new String[] {"rain coat", "umbrella", "Flu tablets"}, 
				new float[] {5000, 2000, 500})
				);
	}

}
