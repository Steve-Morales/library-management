package com.library_management.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class CheckOut {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "book_book_id")
    @JsonProperty("book_book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "person_personid")
    @JsonProperty("person_personid")
    private Person person;

    @JsonProperty("check_out_date")
    private Date checkOutDate;
    
    @Override
    public String toString() {
        return "CheckOut{" +
                "id=" + id +
                ", book=(" + book.toString() +")\n" +
                ", person=(" + person.toString() + ")\n"+
                ", checkOutDate=" + checkOutDate +
                '}';
    }
    
    public void setBook(Book book) { this.book = book; }
    public void setPerson(Person person) { this.person = person; }
    public void setCheckoutDate(Date date) { this.checkOutDate = date; }
    
    public Book getBook() { return book; }
    public Person getPerson() { return person; }
    public Date getCheckoutDate() { return checkOutDate; }
    
}
