package com.datagrokr.multipledatabases.dao.seconddatabaserepo;

import com.datagrokr.multipledatabases.entity.seconddatabase.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("secondUser")
public interface UserRepository extends JpaRepository<User, Integer> {
}
