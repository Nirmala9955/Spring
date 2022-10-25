package com.nt.factory;

import com.nt.components.ApolloTyre;
import com.nt.components.CEATTyre;
import com.nt.components.Engine;
import com.nt.components.FlatEngine;
import com.nt.components.InlineEngine;
import com.nt.components.MRFTyre;
import com.nt.components.StraightEngine;
import com.nt.components.Tyre;
import com.nt.components.Vehecle;

public class VehecleFactory {
	
	public static Vehecle getInstance(String engineName, String tyreName) {
		Engine engine = null;
		Tyre tyre = null;
		Vehecle vehecle = null; 
		if (engineName.equalsIgnoreCase("straight") && tyreName.equalsIgnoreCase("ceat")) {
			engine = new StraightEngine();
			tyre = new CEATTyre();
		} else if (engineName.equalsIgnoreCase("flat") && tyreName.equalsIgnoreCase("mrf")) {
			engine = new FlatEngine();
			tyre = new MRFTyre();
		} else if (engineName.equalsIgnoreCase("Inline") && tyreName.equalsIgnoreCase("apollo")) {
			engine = new InlineEngine();
			tyre = new ApolloTyre();
		} else {
			throw new IllegalArgumentException("not available the provide type");
		}
		
		//create target class object
		vehecle = new Vehecle();
		//assign dependent object to the target class object
		vehecle.setEngine(engine);
		vehecle.setTyre(tyre);
			 
		return vehecle;
	}

}
