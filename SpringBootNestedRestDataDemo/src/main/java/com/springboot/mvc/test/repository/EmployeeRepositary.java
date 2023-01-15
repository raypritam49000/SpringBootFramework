package com.springboot.mvc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mvc.test.model.Employee;
@Repository
public interface EmployeeRepositary extends JpaRepository<Employee, Integer> {

}
