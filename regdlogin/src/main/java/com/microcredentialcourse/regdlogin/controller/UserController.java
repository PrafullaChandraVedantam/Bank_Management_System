package com.microcredentialcourse.regdlogin.controller;

import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcredentialcourse.regdlogin.RegdloginApplication;
import com.microcredentialcourse.regdlogin.dao.UserDao;
import com.microcredentialcourse.regdlogin.model.ApiResponse;
import com.microcredentialcourse.regdlogin.model.SignUpDto;
import com.microcredentialcourse.regdlogin.model.User;
import com.microcredentialcourse.regdlogin.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author javacloudmc449
 *
 */
@RestController
@RequestMapping("/v1")
public class UserController {
	Logger log = LoggerFactory.getLogger(RegdloginApplication.class);
	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;
	/**
	 * 
	 * @param signUpDto
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "breaker")
	@PostMapping("/registration")
	@ApiOperation(value = "please provide the details as given in model schema" + " without changing the order")
	public ApiResponse signUp(@RequestBody SignUpDto signUpDto) {
		if (signUpDto==null) {
			throw new RuntimeException();
		}

		log.trace("Registration method is accesed");
		return userService.signUp(signUpDto);
	}
	/**
	 * 
	 * @param signUpDto
	 * @return
	 */
	public ApiResponse breaker(@RequestBody SignUpDto signUpDto) {
		return new ApiResponse(HttpStatus.SC_GATEWAY_TIMEOUT, "Circuit Breaker Activated", null);

	}


	/**
	 * 
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "getbreaker")
	@GetMapping(value = "/customerdetails")
	@ApiOperation(value = "Click here,to review the customer details")
	public List<User> getAllUser() {
		log.trace("Customer details method is accesed");
		return (List<User>) userDao.findAll();
		
	}
	public List<User> getbreaker() {
		return null;
	}
	/**
	 * 
	 * @param regd_id
	 * @return
	 * @throws Exception
	 */
	@HystrixCommand(fallbackMethod = "getidbreaker")
	@GetMapping(value = "/customer_{regd_id}")
	public User getCustById(@PathVariable int regd_id) throws Exception {
		Optional<User> cust = userDao.findById(regd_id);
		if(cust.isPresent()) {
			return cust.get();
		}
		else {
			throw new RuntimeException("Customer not found with given id");
		}
		
	}
	
	public User getidbreaker(int regd_id) throws Exception {
		return null;
	}
}