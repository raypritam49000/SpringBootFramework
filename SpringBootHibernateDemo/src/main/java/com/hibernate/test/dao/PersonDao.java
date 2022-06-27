package com.hibernate.test.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.test.model.Person;

@Repository
//@Transactional
public class PersonDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void savePerson(Person person) {
		sessionFactory.openSession().save(person);
	}

	public List<Person> getPersons() {
		Session session = sessionFactory.openSession();
		List<Person> persons = session.createCriteria(Person.class).list();
		return persons;
	}

	public Person getPersonById(int id) {
		Person person = (Person) sessionFactory.openSession().get(Person.class, id);
		return person;
	}
	
//	@Transactional
//	public void updatePersonById(int id,String name) {
//		Person person = (Person) sessionFactory.openSession().get(Person.class, id);
//		if(person!=null) 
//		{
//		   Query query = sessionFactory.openSession().createQuery("Upadate set name =:n Where id =:i");
//		   query.setParameter("n",name);
//		   query.setParameter("i",id);
//		   query.executeUpdate();
//		}
//	}
}
