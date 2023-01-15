package com.jdbc.test.dao;

import com.jdbc.test.model.Employee;

public interface EmployeeDao {
	public abstract void createEmployee(Employee employee);

	public abstract Employee getEmployeeById(int id);

	public abstract void updateEmployeeEmailById(Integer id, String newEmail);

	public abstract void deleteEmployeeById(int id);
}
