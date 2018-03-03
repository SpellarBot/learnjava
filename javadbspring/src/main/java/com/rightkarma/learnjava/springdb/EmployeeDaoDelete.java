package com.rightkarma.learnjava.springdb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class EmployeeDaoDelete extends EmployeeDao {
	
	/**
	 * Delete statements - types 
	 * PreparedStatement style - straight forward 
	 * NamedTemplate- if you have lot of parameters to be passed to the query
	 * 
	 **/
	public void deleteEmployees() {
		int update = jdbcTemplate.update("delete from newemployees");
		System.out.println("delete records : "+update);
	}
	public void deleteEmployee(Employee e) {
		int update = jdbcTemplate.update("delete from newemployees where employee_id = ?", e.getEmployeeId());
		System.out.println("delete records : "+update);
	}
	public void deleteEmployeeNamedParameter(Employee e) {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("employee_id", e.getEmployeeId());
		
		int update = template.update("delete from newemployees where employee_id = :employee_id", paramMap);
		System.out.println("delete records : "+update);
	}


}
