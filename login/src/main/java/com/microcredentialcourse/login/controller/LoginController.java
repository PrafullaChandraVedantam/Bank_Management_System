package com.microcredentialcourse.login.controller;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcredentialcourse.login.LoginApplication;
import com.microcredentialcourse.login.model.LoginDto;
import com.microcredentialcourse.login.service.LoginService;
import com.microcredentialcourse.regdlogin.model.ApiResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.ApiOperation;
/**
 * 
 * @author javacloudmc449
 *
 */
@RestController
@RequestMapping("/v1")
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginApplication.class);
	@Autowired
	private LoginService userService;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/**
	 * 
	 * @param loginDto
	 * @return
	 */
	
	@HystrixCommand(fallbackMethod = "breaker")
	@PostMapping("/customerlogin")
	@ApiOperation(value = "Hello Customer,please login ")
	public ApiResponse login(@RequestBody LoginDto loginDto) {
		if (loginDto==null) {
			throw new RuntimeException();
		}
		log.trace("Login method is accesed");
		return userService.login(loginDto);
	}
	public ApiResponse breaker(@RequestBody LoginDto loginDto) {
		return new ApiResponse(HttpStatus.SC_GATEWAY_TIMEOUT, "Circuit Breaker Activated",passwordEncoder.encode(loginDto.getPassword()) );
		
	}
	
	

}
