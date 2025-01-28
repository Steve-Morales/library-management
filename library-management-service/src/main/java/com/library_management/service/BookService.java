package com.library_management.service;

import java.util.List;
import java.util.UUID;

import com.library_management.entity.Book;

public interface BookService {
	List<Book> getAllBooks();
	Book getBook(UUID bookID);
	Book addBook(Book newBook);
	Book updateBook(Book updatedBook);
	String deleteBook(Book book);
}
