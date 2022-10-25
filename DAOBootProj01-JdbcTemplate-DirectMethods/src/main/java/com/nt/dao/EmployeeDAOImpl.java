package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPLOYEES_COUNT = "SELECT COUNT(*) FROM EMP"; 
	private static final String GET_EMPLOYEE_NAME_BY_ID = "SELECT ENAME FROM EMP WHERE EMPNO=?"; 
	private static final String GET_EMPLOYEE_DETAILS_BY_ID = "SELECT EMPNO, ENAME, SAL, JOB, DEPTNO FROM EMP WHERE EMPNO=?"; 
	private static final String GET_EMPLOYEES_DETAILS_BY_JOB = "SELECT EMPNO, ENAME, SAL, JOB, DEPTNO FROM EMP WHERE JOB IN (?, ?) ORDER BY JOB"; 
	private static final String INSERT_EMPLOYEE = "INSERT INTO EMP  (EMPNO, ENAME, JOB, SAL) VALUES (ENO_SEQ.NEXTVAL, ?, ?, ?)"; 
	private static final String ADD_BONUS_BY_JOB = "UPDATE EMP SET SAL=SAL+? WHERE JOB=?"; 
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int getEmployeeCount() {
		int count = 0;
		count = jt.queryForObject(GET_EMPLOYEES_COUNT, Integer.class);
		return count;
	}
	
	@Override
	public String getEmployeeNameByNo(int eno) {
		String name = null;
		name = jt.queryForObject(GET_EMPLOYEE_NAME_BY_ID, String.class, eno);
		return name;
	}
	
	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		Map<String, Object> map = null;
		map = jt.queryForMap(GET_EMPLOYEE_DETAILS_BY_ID, eno);
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getEmployeesDetailsByDesg(String desg1, String desg2) {
		return jt.queryForList(GET_EMPLOYEES_DETAILS_BY_JOB, desg1, desg2);
	}
	
	@Override
	public int insert(String name, String desg, float sal) {
		return jt.update(INSERT_EMPLOYEE, name, desg, sal);
	}
	
	@Override
	public int addBonusToEmployeeByDesg(String desg, float bonus) {
		return jt.update(ADD_BONUS_BY_JOB, bonus, desg);
	}
}
