package com.springboot.mvc.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mvc.test.model.Employee;
import com.springboot.mvc.test.repository.EmployeeRepositary;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepositary employeeRepositary;

	@Override
	public void createEmployee(Employee e) {
		this.employeeRepositary.save(e);
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> optional = this.employeeRepositary.findById(id);
		Employee employee = optional.get();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return this.employeeRepositary.findAll();
	}

	@Override
	public void deleteEmpById(int id) {
		this.employeeRepositary.deleteById(id);
	}

	@Override
	public void updateEmpById(Employee employee, int id) {
		employee.setId(id);
		this.employeeRepositary.save(employee);	
	}

}
