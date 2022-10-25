package com.cb.locator;

import com.ipl.external.IIPLScoreComp;
import com.ipl.external.IPLScoreCompImpl;

public class IPLScoreCompServiceLocator { 
	
	final static IIPLScoreComp extComp = new IPLScoreCompImpl();
	
	public static IIPLScoreComp getExternalComponent () {
		return extComp;
	}

}
