package com.springboot.mvc.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mvc.test.model.Employee;
import com.springboot.mvc.test.service.EmployeeService;

@RestController
public class HomeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public String saveEmp(@RequestBody Employee employee) {
		this.employeeService.createEmployee(employee);
	  return "success";	
	}
	
	@GetMapping("/get/{id}")
	public Employee getEmpById(@PathVariable("id") int id) {
		return	this.employeeService.getEmployeeById(id); 
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployess(){
		return this.employeeService.getAllEmployee();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmpById(@PathVariable("id") int id) {
		this.employeeService.deleteEmpById(id);
		return "delete successfully";
	}
	
	@PutMapping("/update/{id}")
	public String updateByid(@PathVariable("id") int id,@RequestBody Employee employee) {
		this.employeeService.updateEmpById(employee, id);
		return "update successfully";
	}
}
