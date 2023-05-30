package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.object.HeaderResponse;
import com.example.demo.api.request.APIRequest;
import com.example.demo.api.response.APIResponse;
import com.example.demo.constant.StatusCode;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    
    private static final Logger LOG = LogManager.getLogger(UserController.class);

    @Autowired
	UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponse<?> login(@RequestBody String input) {
		LOG.traceEntry();
		APIResponse<User> response = new APIResponse<User>();
		StatusCode statusTrx = StatusCode.SUCCESS;
		try {
			LOG.info("LOGIN");
			APIRequest<User> req = getRequestUser(input);
			User user = userService.isValidUser( req.getPayload().getUsername(), req.getPayload().getPassword() );
			if (user == null) {
				statusTrx = StatusCode.FAILED;
			} else {
				response.setPayload(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("ERR::[{}]:{}", e.getMessage());
			statusTrx = StatusCode.GENERIC_ERROR;
		}
		response.setHeader(new HeaderResponse(statusTrx.getCode(), statusTrx.getStatusDesc()));
		LOG.debug("RES::[{}]:{}", response);
		LOG.traceExit();
		return response;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponse<?> register(@RequestBody String input) {
		LOG.traceEntry();
		APIResponse<User> response = new APIResponse<User>();
		StatusCode statusTrx = StatusCode.SUCCESS;
		try {
			LOG.info("REGISTER");
			APIRequest<User> req = getRequestUser(input);
			if ( !userService.saveUser( req.getPayload() ) ) {
				statusTrx = StatusCode.FAILED;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERR::[{}]:{}", e.getMessage());
			statusTrx = StatusCode.GENERIC_ERROR;
		}
		response.setHeader(new HeaderResponse(statusTrx.getCode(), statusTrx.getStatusDesc()));
		LOG.debug("RES::[{}]:{}", response);
		LOG.traceExit();
		return response;
	}

}
