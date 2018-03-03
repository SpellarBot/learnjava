package com.rightkarma.learnjava.springdb;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeDaoUpdate extends EmployeeDao {
	
	/**
	 * Update statements - types 
	 * PreparedStatement style - straight forward 
	 * batchUpdate - very good for mulitple updates.
	 * 
	 **/
	public void updateEmployee(Employee e) {
		jdbcTemplate.update("update newemployees set last_name=?, email=? where employee_id = ?", e.getLastName(), e.getEmail(), e.getEmployeeId());
	}
	public void updateEmployees(List<Object []> pairs) {
		jdbcTemplate.batchUpdate("update newemployees set last_name=? where employee_id = ?", pairs);
	}
	
	@Transactional
	public void updateEmployeeTransactional(Employee e) {
		jdbcTemplate.update("update newemployees set last_name=?, email=? where employee_id = ?", e.getLastName(), e.getEmail(), e.getEmployeeId());
		throw new DataAccessException("Forced failure..") {
			private static final long serialVersionUID = 1L;
		};
	}

}
