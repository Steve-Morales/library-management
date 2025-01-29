package com.library_management.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library_management.entity.Person;
import com.library_management.service.PersonService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getAllPeople() {
        return ResponseEntity.ok(personService.getAllPeople());
    }

    @GetMapping("/people/{personId}")
    public ResponseEntity<Person> getPerson(@PathVariable("personId") UUID personId) {
        Person person = personService.getPerson(personId);
        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @PostMapping("/people")
    public ResponseEntity<Person> addPerson(@RequestBody Person newPerson) {
        return ResponseEntity.ok(personService.addPerson(newPerson));
    }

    @PutMapping("/people/{personId}")
    public ResponseEntity<Person> updatePerson(@PathVariable("personId") UUID personId, @RequestBody Person updatedPerson) {
        if (personService.getPerson(personId) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personService.updatePerson(updatedPerson));
    }

    @DeleteMapping("/people/{personId}")
    public ResponseEntity<String> deletePerson(@PathVariable("personId") UUID personId) {
        Person personToDelete = personService.getPerson(personId);
        if (personToDelete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personService.deletePerson(personToDelete));
    }
}
