package com.androjavatech4u.rapo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.androjavatech4u.entities.Employee;

@RepositoryRestResource(collectionResourceRel = "emp", path = "empdetails")
public interface EmpRapo extends JpaRepository<Employee, Integer> {
}
