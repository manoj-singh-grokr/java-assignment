package com.datagrokr.multipledatabases.dao.firstdatabaserepo;

import com.datagrokr.multipledatabases.entity.firstdatabase.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("firstBook")
public interface BookRepository extends JpaRepository<Book, Integer> {
}
