package com.hibernate.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="personId")
	private int id;
	@Column(name="personName")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/mm/yyyy")
	@Column(name="personDob")
	private Date dob;
}
