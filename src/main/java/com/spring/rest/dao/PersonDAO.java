package com.spring.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.rest.dto.Person;

@Repository
public class PersonDAO {

	List<Person> personList = new ArrayList<>();

	public String addPerson(Person person) {
		personList.add(person);
		return "person added with id :" + person.getId();
	}

	public Person getPersonById(int id) {
		return personList.stream().filter(p -> p.getId() == id).findAny().get();
	}

	public List<Person> getPersonList() {
		return personList;
	}
}
