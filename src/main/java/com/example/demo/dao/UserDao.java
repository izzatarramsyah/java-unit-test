package com.example.demo.dao;

import com.example.demo.entity.User;

public interface UserDao {
    
    User getUserByUsername(String username) throws Exception;
    boolean saveUser(User user) throws Exception;

}
