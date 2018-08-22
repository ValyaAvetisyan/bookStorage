package com.example.bookstorage.repository.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "book_user")
public class BookUserEntity {
    @ManyToMany
    @JoinColumn(name = "user_id")
    private UserEntity userId;
    private BookEntity bookId;
    private Date takenDate;
    private Date returnDate;

}
