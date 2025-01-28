package com.library_management.repository;

import java.util.UUID;

import com.library_management.entity.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, UUID> {

}
