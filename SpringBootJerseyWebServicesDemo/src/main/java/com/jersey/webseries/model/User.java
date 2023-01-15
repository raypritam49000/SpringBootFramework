package com.jersey.webseries.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
	private int id;
	@Column(name="userName",nullable = false)
	private String name;
	@Column(name="userCity",nullable = false)
	private String city;
	@Column(name="userPhone",nullable = false)
	private String phone;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String city, String phone) {
		super();
		this.name = name;
		this.city = city;
		this.phone = phone;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", city=" + city + ", phone=" + phone + "]";
	}

}
