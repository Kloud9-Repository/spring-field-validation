package com.spring.rest.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.dto.Person;
import com.spring.rest.service.PersonService;

@RestController
public class PersonRestController {
	@Autowired
	private PersonService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addPerson(@Valid @RequestBody Person person, Errors errors)
			throws ValidationException {
		if (errors.hasErrors()) {
			throw new ValidationException(errors.toString());
		}
		String serviceResp = service.addPerson(person);

		return new ResponseEntity<>(serviceResp, HttpStatus.OK);
	}

	@RequestMapping(value = "/getPerson/{id}", method = RequestMethod.GET, produces = "application/json")
	public Person getPerson(@PathVariable("id") int id) {
		Person person = service.getPerson(id);
		if (person != null) {
			return person;
		} else {
			throw new IllegalAccessError("user not found");
		}
	}

	@RequestMapping(value = "/getPersons", method = RequestMethod.GET, produces = "application/json")
	public List<Person> getPerson() {
		return service.getPersons();
	}
}
