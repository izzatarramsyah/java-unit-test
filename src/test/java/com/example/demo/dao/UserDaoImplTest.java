package com.example.demo.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.entity.User;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("local")
public class UserDaoImplTest {

    @Autowired
	private UserDao userDao;
    
    @Test
	public void testFindUserByUserName() {
		try {
			User result = userDao.getUserByUsername( "testing" );
			if ( result == null ) fail();
		} catch ( Exception e ) {
			fail();
		}
	}

	@Test
	@Rollback(true)
	public void testSaveUser() {
		try {
			User user = new User();
			user.setEmail("testing@gmail.com");
			user.setPassword("testing");
			user.setFullname("testing");
			user.setAddress("testing");
			user.setPhoneNo("testing");
			Boolean result = userDao.saveUser( user );
			if ( !result ) fail();
		} catch ( Exception e ) {
			fail();
		}
	}

}
