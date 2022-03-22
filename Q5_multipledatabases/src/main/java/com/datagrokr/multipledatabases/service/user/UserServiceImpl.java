package com.datagrokr.multipledatabases.service.user;

import com.datagrokr.multipledatabases.dao.firstdatabaserepo.UserRepository;
import com.datagrokr.multipledatabases.entity.firstdatabase.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService<User> {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
