package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Type; 

import com.example.demo.api.request.APIRequest;
import com.example.demo.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController {
    
    private static final Logger LOG = LogManager.getLogger(BaseController.class);

    protected <T> Object getObjectsMapper(String content, Class<T> valueType) throws JsonParseException, JsonMappingException, IOException{		
		ObjectMapper mapper = new ObjectMapper();
		return (T)mapper.readValue(content, valueType);
	}

    public APIRequest < User > getRequestUser(String content) throws Exception {
        Gson gson = new Gson();
        Type fooType = new TypeToken<APIRequest< User >>(){}.getType();
        LOG.info("REQ::{}", content.toString());
        return gson.fromJson(content, fooType);
    }

}
