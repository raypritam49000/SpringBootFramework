package com.jdbc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdbc.test.dao.EmployeeDao;
import com.jdbc.test.model.Employee;

@SpringBootApplication
public class SpringBootJdbcDemoApplication implements CommandLineRunner {
	@Autowired
	private EmployeeDao employeeDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcDemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		createEmployee();
		getEmployeeById(1);
		updateEmployeeEmailById( 1,"Amit786@gamil.com");
		 deleteEmployeeById(2);
	}

	private void createEmployee() {
		Employee employee = new Employee("Amit Kumar", "Amit123@gmail.com", 20000.0);
		this.employeeDao.createEmployee(employee);

	}

	private void getEmployeeById(int id) {
		Employee employee = this.employeeDao.getEmployeeById(id);
		System.out.println(employee);
	}

	public void updateEmployeeEmailById(Integer id, String newEmail) {
      this.employeeDao.updateEmployeeEmailById(id,newEmail);
	};
	
	public void deleteEmployeeById(int id) {
		this.employeeDao.deleteEmployeeById(id);
		System.out.println("Delete Employee Successfully....");
	}

}
