package com.example.demo.entity;

import static org.junit.Assert.*;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import pl.pojo.tester.api.assertion.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AllEntityTest {
    
    @Test
	public final void UserTest() {
		final Class<?> classUnderTest = User.class;
		User instance = new User();
		instance.toString();
		instance.getUsername();
		instance.getPassword();
		instance.getAddress();
		instance.getEmail();
		instance.getPhoneNo();
		instance.getStatus();
		instance.getLastActivity();
		instance.getCreatedDtm();
		instance.getCreatedBy();
		instance.getUpdatedDtm();
		instance.getUpdatedBy();
		if (instance.toString() == null || instance.equals("") || instance.equals(new String()))
			fail();
		assertPojoMethodsFor(classUnderTest).testing(Method.GETTER).testing(Method.SETTER).testing(Method.CONSTRUCTOR)
				.areWellImplemented();
	}
    
}
