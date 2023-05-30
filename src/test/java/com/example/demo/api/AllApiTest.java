package com.example.demo.api;

import static org.junit.Assert.*;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import pl.pojo.tester.api.assertion.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.api.object.HeaderRequest;
import com.example.demo.api.object.HeaderResponse;
import com.example.demo.api.request.APIRequest;
import com.example.demo.api.response.APIResponse;

@RunWith(SpringJUnit4ClassRunner.class)
public class AllApiTest {

    @Test
	public final void HeaderRequestTest() {
		final Class<?> classUnderTest = HeaderRequest.class;
		HeaderRequest instance = new HeaderRequest();
		instance.toString();
		instance.getSession();
        instance.getUname();
        instance.getChannel();
        instance.getCommand();
		if (instance.toString() == null || instance.equals("") || instance.equals(new String()))
			fail();
		assertPojoMethodsFor(classUnderTest).testing(Method.GETTER).testing(Method.SETTER).testing(Method.CONSTRUCTOR)
			.areWellImplemented();
	}
    
    @Test
	public final void HeaderResponseTest() {
		final Class<?> classUnderTest = HeaderResponse.class;
		HeaderResponse instance = new HeaderResponse();
		instance.getResponseCode();
        instance.getResponseMessage();
		if (instance.toString() == null || instance.equals("") || instance.equals(new String()))
			fail();
		assertPojoMethodsFor(classUnderTest).testing(Method.GETTER).testing(Method.SETTER).testing(Method.CONSTRUCTOR)
				.areWellImplemented();
	}

    @Test
	public final <T> void APIRequestTest() {
		final Class<?> classUnderTest = APIRequest.class;
		APIRequest<?> instance = new APIRequest<T>();
		instance.toString();
		instance.getHeader();
        instance.getPayload();
		if (instance.toString() == null || instance.equals("") || instance.equals(new String()))
			fail();
		assertPojoMethodsFor(classUnderTest).testing(Method.GETTER).testing(Method.SETTER).testing(Method.CONSTRUCTOR)
        		.areWellImplemented();
	}

    @Test
	public final <T> void APIResponseTest() {
		final Class<?> classUnderTest = APIResponse.class;
		APIResponse<?> instance = new APIResponse<T>();
		instance.toString();
		instance.getHeader();
        instance.getPayload();
		if (instance.toString() == null || instance.equals("") || instance.equals(new String()))
			fail();
		assertPojoMethodsFor(classUnderTest).testing(Method.GETTER).testing(Method.SETTER).testing(Method.CONSTRUCTOR)
				.areWellImplemented();
	}

}
