package com.library_management.service;

import java.util.List;
import java.util.UUID;

import com.library_management.entity.Person;

public interface PersonService {
	List<Person> getAllPeople();
	Person getPerson(UUID personID);
	Person addPerson(Person newPerson);
	Person updatePerson(Person updatePerson);
	String deletePerson(Person person);
}
