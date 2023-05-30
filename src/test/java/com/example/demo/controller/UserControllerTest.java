package com.example.demo.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import com.example.demo.api.request.APIRequest;
import com.example.demo.api.response.APIResponse;
import com.example.demo.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("local")
public class UserControllerTest {

    private MockMvc mock;

    @Autowired
    UserController userController;
    
    @Autowired
	WebApplicationContext webApplicationContext;
	 
	@Before
	public void setUp() { //configure mock mvc manually
		MockitoAnnotations.initMocks(this);
		this.mock = MockMvcBuilders.webAppContextSetup(webApplicationContext)
			.build();
	}
    
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
   
    @Test
	public void loginTest(){
		APIRequest<User> input = new APIRequest<User>();
        User user = new User();
        user.setUsername("testing");
        user.setPassword("testing");
        input.setPayload(user);
        try {
			String json = mapToJson(input);
			MvcResult mvcResult = mock.perform(post("/user/login") // Test controller
					  	.content(json)
				   		.contentType(MediaType.APPLICATION_JSON_VALUE))
				   		.andReturn();
			int result = mvcResult.getResponse().getStatus();
			assertEquals(result, 200);
			String content = mvcResult.getResponse().getContentAsString();
			APIResponse<User> resultObj = (APIResponse<User>) userController.getObjectsMapper(content, APIResponse.class);
			assertTrue(resultObj!=null);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}	
	}

    @Test
    @Rollback(true)
	public void registerTest(){
		APIRequest<User> input = new APIRequest<User>();
        User user = new User();
        user.setEmail("testing@gmail.com");
        user.setPassword("testing");
        user.setFullname("testing");
        input.setPayload(user);
        try {
			String json = mapToJson(input);
			MvcResult mvcResult = mock.perform(post("/user/register") // Test controller
					  	.content(json)
				   		.contentType(MediaType.APPLICATION_JSON_VALUE))
				   		.andReturn();
			int result = mvcResult.getResponse().getStatus();
			assertEquals(result, 200);
			String content = mvcResult.getResponse().getContentAsString();
			APIResponse<User> resultObj = (APIResponse<User>) userController.getObjectsMapper(content, APIResponse.class);
			assertTrue(resultObj!=null);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}	
	}

}
