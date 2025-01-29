package com.library_management.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_management.entity.Person;
import com.library_management.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPeople() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person getPerson(UUID personID) {
        Optional<Person> person = personRepository.findById(personID);
        return person.orElse(null); // Return null if not found (consider throwing an exception instead)
    }

    @Override
    public Person addPerson(Person newPerson) {
        return personRepository.save(newPerson);
    }

    @Override
    public Person updatePerson(Person updatePerson) {
        return personRepository.save(updatePerson);
    }

    @Override
    public String deletePerson(Person person) {
            personRepository.delete(person);
            return "Person " + person.toString() + " has been deleted.";

    }
}