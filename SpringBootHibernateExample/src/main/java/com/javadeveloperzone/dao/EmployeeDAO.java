package com.javadeveloperzone.dao;

import com.javadeveloperzone.model.Employee;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
//@Repository
public class EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> getEmployeeList() {
		return sessionFactory.openSession().createCriteria(Employee.class).list();
	}

	@Transactional
	public int saveEmployee(Employee employee) {
		return  (Integer)sessionFactory.openSession().save(employee);
	}
}