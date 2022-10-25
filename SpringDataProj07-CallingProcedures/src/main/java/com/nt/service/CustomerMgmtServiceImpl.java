package com.nt.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("custService")
@Transactional
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	
	
	@Autowired
	private EntityManager manager;	
	
	@Override
	public void getEmployById(int no) {
		//get seesion object
		Session ses = manager.unwrap(Session.class);
		float sal = ses.doReturningWork(new ReturningWork<Float>() {
			
			@Override
			public Float execute(Connection con) throws SQLException {
				//create CallableStatement
				CallableStatement cs = con.prepareCall("{?=call FX_GET_EMP_DETAILS_BY_NO(?,?,?,?)}");
				//register Return, OUT params with JDBC types
				cs.registerOutParameter(1, java.sql.Types.FLOAT);
				cs.registerOutParameter(3, java.sql.Types.VARCHAR);
				cs.registerOutParameter(4, java.sql.Types.VARCHAR);
				cs.registerOutParameter(5, java.sql.Types.INTEGER);
				//set value to IN param
				cs.setInt(2, no);
				//call PL/SQL function
				cs.execute();
				//gether resuts from OUT params and Return Param
				System.out.println("Emp NAME : "+cs.getString(3));
				System.out.println("EMP DESG : "+cs.getString(4));
				System.out.println("DEPT NO : "+cs.getInt(5));
				return cs.getFloat(1);
			}
		
		});
		System.out.println("Emp Salary : "+sal);
	}
}
