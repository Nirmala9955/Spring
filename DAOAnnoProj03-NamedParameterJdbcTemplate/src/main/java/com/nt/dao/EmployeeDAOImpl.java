package com.nt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMPLOYEE_NAME_BY_ID = "SELECT ENAME FROM EMP WHERE EMPNO=:no";
	private static final String GET_EMPLOYEE_NAME_BY_JOBS = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE JOB IN (:desg1, :desg2, :desg3)";
	private static final String INSERT_EMPLOYEE = "INSERT INTO EMP (EMPNO, ENAME, JOB, SAL) VALUES (:empno, :ename, :job, :sal)";
	
	@Autowired
	private NamedParameterJdbcTemplate npjt;
	
	@Override
	public String getEmployeeNameByNo(int no) {
		Map<String, Object> paramMap = Map.of("no", no);
		String name = npjt.queryForObject(GET_EMPLOYEE_NAME_BY_ID, paramMap, String.class);
		return name;
	}

	@Override
	public List<EmployeeBO> getEmployeeDetailsByDesgs(String desg1, String desg2, String desg3) {
		//Prepare MapSqlParameterSource Object having names, values of the named parameters
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("desg1", desg1);
		msps.addValue("desg2", desg2);
		msps.addValue("desg3", desg3);
		List<EmployeeBO> listBO = npjt.query(GET_EMPLOYEE_NAME_BY_JOBS, msps, rs->{
			List<EmployeeBO> listBO1 = new ArrayList<>();
			while(rs.next()) {
				EmployeeBO bo = new EmployeeBO();
				bo.setEmpno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				listBO1.add(bo);
			}
			return listBO1;
		});
		return listBO;
	}

	@Override
	public int insertEmployee(EmployeeBO bo) {
		// create BeanPropertySqlParameterSource object
		BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(bo);
		//execute query
		return npjt.update(INSERT_EMPLOYEE, bpsps);
	}

}
