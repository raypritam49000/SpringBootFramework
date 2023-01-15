package com.jdbc.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc.test.model.Employee;
import com.jdbc.test.model.EmployeeRowMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee(Employee employee) {
		String sql = "insert into employee(name,email,salary) values(?,?,?)";
		int update = this.jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getSalary());
		if (update > 0) {
			System.out.println("Create Employee Successfully...");
		} else {
			System.out.println("Problem Occur then can be Slove First....");
		}
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from employee where id=?";
		Employee employee = this.jdbcTemplate.queryForObject(sql,new EmployeeRowMapper(),id);
		return employee;
	}

	@Override
	public void updateEmployeeEmailById(Integer id, String newEmail) {
		String sql = "update employee set email=? where id = ?";
		int update = this.jdbcTemplate.update(sql,newEmail,id);
		if(update>0)
			System.out.println("Update Details Successfully...");
		else
			System.out.println("Does not update....");

	}

	@Override
	public void deleteEmployeeById(int id) {
	    String sql = "DELETE FROM employee where id = ? ";
        this.jdbcTemplate.update(sql,id);
	}

}
