package com.library_management.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID bookId;
	private String author;
	private String title;
	private Date published;
	private String ISBN_10;
	private String ISBN_13;
	private String publisher;
	
	@Override
	public String toString() {
	    return "Book{" +
	           "bookId=" + bookId +
	           ", author='" + author + '\'' +
	           ", title='" + title + '\'' +
	           ", published=" + published +
	           ", ISBN_10='" + ISBN_10 + '\'' +
	           ", ISBN_13='" + ISBN_13 + '\'' +
	           ", publisher='" + publisher + '\'' +
	           '}';
	}
}
