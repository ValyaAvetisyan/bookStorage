package com.example.demo.repository.entity;

import javax.persistence.*;


/**
 * User entity class
 */
@Table
@Entity
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    @Column
    private String bin;

    @Column
    private String author;

    @Column
    private String name;


    private boolean taken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
