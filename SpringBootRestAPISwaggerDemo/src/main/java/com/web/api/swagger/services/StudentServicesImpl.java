package com.web.api.swagger.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.api.swagger.model.Student;
import com.web.api.swagger.repository.StudentRepository;

@Service
public class StudentServicesImpl implements StudentServices {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void createStudent(Student student) {
		this.studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return this.studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return this.studentRepository.findById(id).get();
	}

	@Override
	public Student getStudentByNameAndCity(String name, String city) {
		return this.studentRepository.findUserByNameAndCity(name, city);
	}

	@Override
	public void deleteStudentById(int id) {
		this.studentRepository.deleteById(id);
	}

}
