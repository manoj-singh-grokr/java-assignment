package com.datagrokr.multipledatabases.entity.firstdatabase;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
    private String book_name;
    private String genre;
    private String author;

    public Book() {
    }

    public Book(Integer book_id, String book_name, String genre, String author) {
        this.book_id = book_id;
        this.author = author;
        this.book_name = book_name;
        this.genre = genre;
    }

    public Book( String author,String book_name, String genre) {
        this.book_name = book_name;
        this.author = author;
        this.genre = genre;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
