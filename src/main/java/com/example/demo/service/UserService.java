package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User isValidUser(String username, String password) throws Exception;
    boolean saveUser(User user) throws Exception;

}
