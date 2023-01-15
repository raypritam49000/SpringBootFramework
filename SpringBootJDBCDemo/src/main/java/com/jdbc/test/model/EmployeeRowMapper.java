package com.jdbc.test.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String email = rs.getString("email");
		double salary = rs.getDouble("salary");
		
		Employee employee = new Employee(name,email,salary);
		employee.setId(id);
		
		return employee;
	}

}
