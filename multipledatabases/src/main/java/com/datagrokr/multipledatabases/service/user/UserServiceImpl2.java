package com.datagrokr.multipledatabases.service.user;

import com.datagrokr.multipledatabases.dao.seconddatabaserepo.UserRepository;
import com.datagrokr.multipledatabases.entity.seconddatabase.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl2 implements UserService<User> {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl2(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
