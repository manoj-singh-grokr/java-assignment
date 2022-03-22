package com.datagrokr.multipledatabases.dao.seconddatabaserepo;

import com.datagrokr.multipledatabases.entity.seconddatabase.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("secondBook")
public interface BookRepository extends JpaRepository<Book, Integer> {
}
