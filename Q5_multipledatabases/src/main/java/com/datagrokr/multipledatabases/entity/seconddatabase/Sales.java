package com.datagrokr.multipledatabases.entity.seconddatabase;

import javax.persistence.*;

@Entity
@Table(name="sales")
public class Sales{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sales_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Sales(){}

    public Sales(Integer sales_id, User user, Book book) {
        this.sales_id = sales_id;
        this.user = user;
        this.book = book;
    }

    public Integer getSales_id() {
        return sales_id;
    }

    public void setSales_id(Integer sales_id) {
        this.sales_id = sales_id;
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

    @Override
    public String toString() {
        return "Sales{" +
                "sales_id=" + sales_id +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}
