package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.PersonDAO;
import com.spring.rest.dto.Person;

@Service
public class PersonService {
	@Autowired
	private PersonDAO dao;

	public String addPerson(Person person) {
		return dao.addPerson(person);
	}

	public Person getPerson(int id) {
		return dao.getPersonById(id);
	}

	public List<Person> getPersons() {
		return dao.getPersonList();
	}
}
