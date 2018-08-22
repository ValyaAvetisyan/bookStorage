package com.example.demo.repository.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity class contains information about book and User relationship.
 * When user take and return the book and etc...
 */

@Table
@Entity
public class UserBook {
    @Id
    @GeneratedValue
    @Column(name = "user_book_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date takenDate;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takenDate) {
        this.takenDate = takenDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
