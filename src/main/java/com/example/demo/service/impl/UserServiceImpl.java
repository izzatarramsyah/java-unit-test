package com.example.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Util;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    
    @Override
    public User isValidUser(String username, String password) throws Exception {
        User user = userDao.getUserByUsername(username);
		if (user != null) {
			String decryptedPassword = Util.decrypt(user.getPassword());
			if (decryptedPassword.equals(password)) {
				return user;
			} else {
				return null;
			}
		}
		return null;
    }

	@Override
	public boolean saveUser(User user) throws Exception {
		user.setUsername(user.getEmail().substring(0, user.getEmail().indexOf("@")));
		user.setPassword(Util.encrypt(user.getPassword()));
		user.setCreatedDtm(new Date());
		user.setCreatedBy("SYSTEM");
		user.setStatus( "ACTIVE" );
		return userDao.saveUser(user);
	}
    
}
