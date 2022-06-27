package com.javadeveloperzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.javadeveloperzone.dao.EmployeeDAO;
import com.javadeveloperzone.model.Employee;

@SpringBootApplication

//@EnableAutoConfiguration
//@Configuration
//@ComponentScan

public class SpringBootConfig {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = (ApplicationContext) SpringApplication.run(SpringBootConfig.class,args);
		EmployeeDAO employeeDAO = applicationContext.getBean(EmployeeDAO.class);
		System.out.println(employeeDAO);
		Employee emp1 = new Employee("Pritam Ray","Java Developer");
        int id = employeeDAO.saveEmployee(emp1);
        System.out.println(id);
        
        employeeDAO.getEmployeeList().forEach(e->System.out.println(e));
	}
	
}