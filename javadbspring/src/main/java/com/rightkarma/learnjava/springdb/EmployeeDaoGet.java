package com.rightkarma.learnjava.springdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDaoGet extends EmployeeDao {
	
	/**
	 * Get statements - types 
	 * PreparedStatement style - using jdbcTemplate.query - ResultSetExtractor - use when you have multiple results 
	 * PreparedStatement style - using jdbcTemplate.query - RowMapper - use when you have single result that you need to put in a pojo
	 * Using jdbcTemplate.queryForObject - - if you want to query for single row.
	 * 
	 **/
	public List<Employee> getEmployeesRSExtractor() {
		return jdbcTemplate.query("SELECT employee_id, first_name, last_name, email FROM NEWEMPLOYEES",
				new ResultSetExtractor<List<Employee>>() {

					@Override
					public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<Employee> list = new ArrayList<Employee>();
						while (rs.next()) {
							list.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
						}
						return list;
					}

				});
	}

	public List<Employee> getEmployeesRowMapper() {
		return jdbcTemplate.query("SELECT employee_id, first_name, last_name, email FROM NEWEMPLOYEES",
				new EmployeeRowMapper());
	}

	// use queryForObject when single object is expected in output.
	public Employee getEmployee(int employeeId) {
		return jdbcTemplate.queryForObject(
				"SELECT employee_id, first_name, last_name, email FROM NEWEMPLOYEES where employee_id=? and rownum < 2",
				new EmployeeRowMapper(), employeeId);
	}

	class EmployeeRowMapper implements RowMapper<Employee> {

		// template pattern method
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}

	}

}
