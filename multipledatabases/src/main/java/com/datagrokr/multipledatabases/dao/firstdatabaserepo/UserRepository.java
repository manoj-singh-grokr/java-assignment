package com.datagrokr.multipledatabases.dao.firstdatabaserepo;

import com.datagrokr.multipledatabases.entity.firstdatabase.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("firstUser")
public interface UserRepository extends JpaRepository<User, Integer> {
}
