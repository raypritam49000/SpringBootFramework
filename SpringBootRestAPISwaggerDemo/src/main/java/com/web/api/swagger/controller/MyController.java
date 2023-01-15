package com.web.api.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.web.api.swagger.model.Student;
import com.web.api.swagger.services.StudentServicesImpl;

@RestController
@RequestMapping("/student")
public class MyController {
	@Autowired
	private StudentServicesImpl servicesImpl;

	@PostMapping("/saveUser")
	private String createStudent(@RequestBody Student student) {
		this.servicesImpl.createStudent(student);
		return "Student save successfully....";
	}

	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent() {
		return this.servicesImpl.getAllStudent();
	}

	@GetMapping("/getStudentById/{id}")
	public Student getStudenrById(@PathVariable("id") int id) {
		return this.servicesImpl.getStudentById(id);
	}

	@GetMapping("/getUserByNameAndCity/{name}/{city}")
	public Student getStudenrByNameAndCity(@PathVariable("name") String name, @PathVariable("city") String city) {
		return this.servicesImpl.getStudentByNameAndCity(name, city);
	}

	@DeleteMapping("/deleteStudentById/{id}")
	public String deleteStudenrById(@PathVariable("id") int id) {
		this.servicesImpl.deleteStudentById(id);
		return "Student are deleted successfully ...";
	}

	@PutMapping("/updateStudentById/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public String updateStudenrById(@PathVariable("id") int id, @RequestBody Student student) {
		student.setId(id);
		this.servicesImpl.createStudent(student);
		return "Student Update Successfully....";
	}

}
