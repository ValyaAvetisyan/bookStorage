package com.example.bookstorage.model;

import java.util.Date;
import java.util.List;

public class BookUserDto {
   private UserDto userId;
   private List <BookDto> bookId;
   private Date takenDate;
   private Date returnDate;

    public BookUserDto(UserDto userId, List<BookDto> bookId, Date takenDate, Date returnDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.takenDate = takenDate;
        this.returnDate = returnDate;
    }

    public BookUserDto() {
    }

    public UserDto getUserId() {
        return userId;
    }

    public void setUserId(UserDto userId) {
        this.userId = userId;
    }

    public List<BookDto> getBookId() {
        return bookId;
    }

    public void setBookId(List<BookDto> bookId) {
        this.bookId = bookId;
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
