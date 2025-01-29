package com.library_management.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "CheckOut", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"bookID", "personID"})
})
public class CheckOut {

    @Id
    @Column(name = "ID", columnDefinition = "CHAR(36)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "bookID", nullable = false, foreignKey = @ForeignKey(name = "fk_checkout_book", foreignKeyDefinition = "FOREIGN KEY (bookID) REFERENCES Book(bookID) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Book book;

    @ManyToOne
    @JoinColumn(name = "personID", nullable = false, foreignKey = @ForeignKey(name = "fk_checkout_person", foreignKeyDefinition = "FOREIGN KEY (personID) REFERENCES Person(personID) ON DELETE CASCADE ON UPDATE CASCADE"))
    private Person person;

    @Column(name = "checkOutDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date checkOutDate;
}
