package com.springboot.mvc.test.service;

import java.util.List;

import com.springboot.mvc.test.model.Employee;

public interface EmployeeService {
public abstract void createEmployee(Employee e);
public abstract Employee getEmployeeById(int id);
public abstract List<Employee> getAllEmployee();
public abstract void deleteEmpById(int id);
public abstract void updateEmpById(Employee employee,int id);
}
