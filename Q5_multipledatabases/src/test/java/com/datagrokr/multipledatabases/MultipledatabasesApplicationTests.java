package com.datagrokr.multipledatabases;

import com.datagrokr.multipledatabases.dao.firstdatabaserepo.UserRepository;
import com.datagrokr.multipledatabases.entity.firstdatabase.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MultipledatabasesApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional("secondTransactionManager")
	public void whenCreatingUser_thenCreated() {
		User user = new User();
		user.setUsername("Mohg");
		userRepository.save(user);
		System.out.println(userRepository.findAll());
	}

}

