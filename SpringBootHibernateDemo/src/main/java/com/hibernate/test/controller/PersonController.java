package com.hibernate.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.test.dao.PersonDao;
import com.hibernate.test.model.Person;

@RestController
public class PersonController {

	@Autowired
	private PersonDao personDao;

	@PostMapping("/savePerson")
	public String save(@RequestBody Person person) {
		this.personDao.savePerson(person);
		return "success";
	}

	@GetMapping("/getAllPerson")
	public List<Person> getPersons() {
		return this.personDao.getPersons();
	}

	@GetMapping("/getPersonById/{id}")
	public Person getPersonById(@PathVariable("id") int id) {
		return (Person)this.personDao.getPersonById(id);
	}
	
//	@PutMapping("/updatePersonById/{id}/{name}",
//	 consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
//	    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
//	public void updatePersonById(@PathVariable("id") int id,@PathVariable("name") String name) {
//	  personDao.updatePersonById(id, name);
//	}
}
