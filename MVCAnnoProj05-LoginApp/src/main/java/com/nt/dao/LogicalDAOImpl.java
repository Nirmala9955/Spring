package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBO;

@Repository("loginDAO")
public class LogicalDAOImpl implements ILoginDAO {
	
	@Autowired
	private SimpleJdbcCall sjc;
	
	@Override
	public String authentication(UserBO bo) {
		Map<String, Object> inParams = null, outParam = null;
		//set Procedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		//Prepare Map object having IN parma name and values
		inParams = new HashMap<>();
		inParams.put("UNAME", bo.getUsername());
		inParams.put("PASS", bo.getPassword());
		//call pl/sql procedure
		outParam = sjc.execute(inParams);
		return (String) outParam.get("RESULT");
	}

}
