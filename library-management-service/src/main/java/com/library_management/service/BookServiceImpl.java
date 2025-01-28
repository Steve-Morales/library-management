package com.library_management.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_management.entity.Book;
import com.library_management.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book getBook(UUID bookID) {
		Optional<Book> book = bookRepository.findById(bookID);
		if (book.isPresent()) {
			return book.get();
		} else {
			throw new RuntimeException("Book not found with ID: " + bookID);
		}
	}

	@Override
	public Book addBook(Book newBook) {
		return bookRepository.save(newBook);
	}

	@Override
	public Book updateBook(Book updatedBook) {
		return bookRepository.save(updatedBook);
	}

	@Override
	public String deleteBook(Book book) {
		bookRepository.delete(book);
		return "Book with ID " + book.toString() + " has been deleted.";
	}
}
