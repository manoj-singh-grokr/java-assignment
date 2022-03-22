package com.datagrokr.multipledatabases.service.book;

import java.util.List;

public interface BookService<T> {
    public List<T> getAllBooks();
    public T getBookById(Integer id);
    public void saveBook(T book);
    public void deleteBookById(Integer id);
}
