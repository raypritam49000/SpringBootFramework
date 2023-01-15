package com.web.api.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.api.swagger.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
 public Student findUserByNameAndCity(String name,String city);
}
