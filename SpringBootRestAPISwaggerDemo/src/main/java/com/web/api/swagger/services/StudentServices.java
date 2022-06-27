package com.web.api.swagger.services;

import java.util.List;

import com.web.api.swagger.model.Student;

public interface StudentServices {
public abstract void createStudent(Student student);
public abstract List<Student> getAllStudent();
public abstract Student getStudentById(int id);
public abstract void deleteStudentById(int id);
public abstract Student getStudentByNameAndCity(String name,String city);


}
