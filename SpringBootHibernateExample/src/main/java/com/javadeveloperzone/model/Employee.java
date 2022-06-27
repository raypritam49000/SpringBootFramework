package com.javadeveloperzone.model;

import javax.persistence.*;

/**
 * Created by Java Developer Zone on 03-08-2017.
 */
@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	@Column
	private String employeeName;
	@Column
	private String employeeRole;

	public Employee(String employeeName, String employeeRole) {
		super();
		this.employeeName = employeeName;
		this.employeeRole = employeeRole;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeRole="
				+ employeeRole + "]";
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
}