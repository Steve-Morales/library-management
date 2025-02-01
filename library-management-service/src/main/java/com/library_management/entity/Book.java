package com.library_management.entity;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("book_id")
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID bookId;
	@JsonProperty("author")
	private String author;
	@JsonProperty("title")
	private String title;
	@JsonProperty("published")
	private Date published;
	@JsonProperty("isbn_10")
	private String ISBN_10;
	@JsonProperty("isbn_13")
	private String ISBN_13;
	@JsonProperty("publisher")
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
