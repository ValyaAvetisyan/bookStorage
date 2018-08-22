package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by home on 8/12/18.
 */
public class BookDto {
    private Long id;
    
    private String bin;
    
    private String author;
    
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
