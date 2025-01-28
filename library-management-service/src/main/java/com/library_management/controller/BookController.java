package com.library_management.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library_management.entity.Book;
import com.library_management.service.BookService;

@CrossOrigin(maxAge = 3360)
@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(bookService.getAllBooks());
	}

	@GetMapping("/books/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable("bookId") UUID bookId) {
		return ResponseEntity.ok(bookService.getBook(bookId));
	}

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
		return ResponseEntity.ok(bookService.addBook(newBook));
	}

	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable("bookId") UUID bookId, @RequestBody Book updatedBook) {
		return ResponseEntity.ok(bookService.updateBook(updatedBook));
	}

	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable("bookId") UUID bookId) {
		Book bookToDelete = bookService.getBook(bookId);
		if(bookToDelete == null) { ResponseEntity.ok(null); }
		return ResponseEntity.ok(bookService.deleteBook(bookToDelete));
	}
}
