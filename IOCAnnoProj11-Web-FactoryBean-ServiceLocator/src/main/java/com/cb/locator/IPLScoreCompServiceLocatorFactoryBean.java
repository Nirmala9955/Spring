package com.cb.locator;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.ipl.external.IIPLScoreComp;
import com.ipl.external.IPLScoreCompImpl;

@Component("locator")
public class IPLScoreCompServiceLocatorFactoryBean implements FactoryBean<IIPLScoreComp> {
	
	private IIPLScoreComp extComp;
	
	public IPLScoreCompServiceLocatorFactoryBean() {
		extComp = new IPLScoreCompImpl();
	}
	
	@Override
	public IIPLScoreComp getObject() throws Exception {
		/*
		 * Technically speaking here we need add Jndi lookup 
		 * code to get external component reference from Jndi 
		 * registry, since we have external component (IPLScoreComp)
		 * as an ordinary java class. we are just going to return 
		 * object for it with out lookup operation.  
		 * */ 	
		return extComp;
	}

	@Override
	public Class<?> getObjectType() {
		return IIPLScoreComp.class;
	}

}
