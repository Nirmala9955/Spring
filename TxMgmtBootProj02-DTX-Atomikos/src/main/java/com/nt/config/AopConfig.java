package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AopConfig {

	@Bean(name ="aDTxService")
	public UserTransactionImp createADTX() {
		return new UserTransactionImp();
	}

	@Bean(name ="aDTxMgmr")
	public UserTransactionManager createADTXMgmr() {
		return new UserTransactionManager();
	}
	
	@Bean("jtaTxMgmr")
	public JtaTransactionManager createJtaTxMgmr() {
		JtaTransactionManager jtaTxMgmr = new JtaTransactionManager();
		jtaTxMgmr.setUserTransaction(createADTX());
		jtaTxMgmr.setTransactionManager(createADTXMgmr());
		return jtaTxMgmr;
	}
	
}
