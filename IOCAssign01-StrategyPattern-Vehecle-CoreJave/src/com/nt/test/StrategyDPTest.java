package com.nt.test;

import java.util.Vector;

import com.nt.components.Vehecle;
import com.nt.factory.VehecleFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
		Vehecle vehecle = null;
		vehecle = VehecleFactory.getInstance("flat", "mrf"); 
		System.out.println(vehecle.getInfromation());
	}

}
