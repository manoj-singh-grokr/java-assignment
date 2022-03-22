package com.datagrokr.multipledatabases.service.book;

import com.datagrokr.multipledatabases.dao.firstdatabaserepo.BookRepository;
import com.datagrokr.multipledatabases.entity.firstdatabase.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService<Book>{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer id) {
        Optional<Book> result = bookRepository.findById(id);
        Book book = null;
        if(result.isPresent()){
            book = result.get();
        } else {
            throw new RuntimeException("Did not find book with id: "+id);
        }
        return book;
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }

}
