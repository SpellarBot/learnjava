package com.rightkarma.learnjava.springdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class EmployeeDaoAdd extends EmployeeDao {
	
	/**
	 * Add statements - types 
	 * PreparedStatement style - straight forward 
	 * ORM style - lot of effort in creating columns, setting map with data before insert is
	 * SimpleJdbc - if you want to get key of inserted object
	 * 
	 **/
	public void addEmployee(Employee e) {
		jdbcTemplate.update("insert into newemployees (employee_id, first_name, last_name, email) values ( ?, ?, ?, ? )", e.getEmployeeId(), e.getFirstName(),
				e.getLastName(), e.getEmail());
	}

	// you can use below method if you want retrieve identity column value. 
	public void addEmployeePS(Employee e) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("insert into newemployees (employee_id, first_name, last_name, email)  values ( ?, ?, ?, ? )", new String[] {"id"} );
				ps.setInt(1,e.getEmployeeId());
				ps.setString(2,e.getFirstName());
				ps.setString(3,e.getLastName());
				ps.setString(4,e.getEmail());
				return ps;
			}
		}, keyHolder);
		System.out.println("keyHolder : "+keyHolder.getKey());
	}

	public void addEmployeeSimpleJdbc(Employee e) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columns = new ArrayList<>();
		columns.add("employee_id");
		columns.add("first_name");
		columns.add("last_name");
		columns.add("email");

		insert.setTableName("newemployees");
		insert.setColumnNames(columns);

		Map<String, Object> data = new HashMap<>();
		data.put("employee_id", e.getEmployeeId());
		data.put("first_name", e.getFirstName());
		data.put("last_name", e.getLastName());
		data.put("email", e.getEmail());

		insert.execute(data);
	}

	public void addEmployeeSimpleJdbcWithKey(Employee e) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		List<String> columns = new ArrayList<>();
		columns.add("employee_id");
		columns.add("first_name");
		columns.add("last_name");
		columns.add("email");

		insert.setTableName("newemployees");
		insert.setColumnNames(columns);
		insert.setGeneratedKeyName("id");

		Map<String, Object> data = new HashMap<>();
		data.put("employee_id", e.getEmployeeId());
		data.put("first_name", e.getFirstName());
		data.put("last_name", e.getLastName());
		data.put("email", e.getEmail());

//		insert.execute(data);
		Number key = insert.executeAndReturnKey(data);
		System.out.println("key: "+key);
	}


}
