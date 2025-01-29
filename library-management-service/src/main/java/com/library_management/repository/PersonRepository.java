package com.library_management.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library_management.entity.Book;
import com.library_management.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID>{

}
