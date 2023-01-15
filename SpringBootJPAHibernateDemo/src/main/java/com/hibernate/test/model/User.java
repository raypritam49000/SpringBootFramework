package com.hibernate.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserId", length = 11, nullable = false)
	private int id;
	@Column(name = "UserName", length = 150, nullable = false)
	private String name;
	@Column(name = "UserStatus", length = 211, nullable = false)
	private String status;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
