package com.nt.test;

import com.nt.components.Flipkart;
import com.nt.factory.FlipkartFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
		Flipkart fpkt = null;
		fpkt=FlipkartFactory.getInstane("dtdc");
		System.out.println(fpkt.shopping(new String[] {"rain coat", "umbrella", "Flu tablets"}, 
				new float[] {5000, 2000, 500})
				);
	}

}
