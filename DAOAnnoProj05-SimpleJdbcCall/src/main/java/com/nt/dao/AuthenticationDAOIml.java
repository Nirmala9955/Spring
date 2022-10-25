package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("authDAO")
public class AuthenticationDAOIml implements IAuthenticationDAO {
	
	@Autowired
	private SimpleJdbcCall sjc;
	
	@Override
	public String authentication(String user, String pwd) {
		//Set procedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		//prepare Map object of IN params
		Map<String, ?> inParams = Map.of("UNAME", user, "PASS", pwd); 
		//call PL/SQL procedure
		Map<String, ?> outParams = sjc.execute(inParams);
		return (String) outParams.get("RESULT");
	}

}
