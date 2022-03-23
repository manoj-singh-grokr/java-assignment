package com.datagrokr.multipledatabases;

import com.datagrokr.multipledatabases.dao.firstdatabaserepo.UserRepository;
import com.datagrokr.multipledatabases.dao.seconddatabaserepo.BookRepository;
import com.datagrokr.multipledatabases.entity.firstdatabase.User;
import com.datagrokr.multipledatabases.entity.seconddatabase.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@EnableTransactionManagement
class Q5MultipledatabasesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Test
	@Transactional("firstTransactionManager")
	public void whenCreatingUser_thenCreated() {
		User user = new User();
		user.setUsername("John");
		user.setUser_id(1);
		user = userRepository.save(user);
		Optional result = userRepository.findById(user.getUser_id());
		assertThat(result.isPresent()).isTrue();
	}


	@Test
	@Transactional("secondTransactionManager")
	public void whenCreatingBook_thenCreated() {
		Book book = new Book("Arther", "Test", "Horror");
		book = bookRepository.save(book);
		Optional result = bookRepository.findById(book.getBook_id());
		assertThat(result.isPresent()).isTrue();
	}
}

