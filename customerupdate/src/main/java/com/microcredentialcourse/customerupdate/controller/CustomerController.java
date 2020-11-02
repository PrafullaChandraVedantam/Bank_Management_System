package com.microcredentialcourse.customerupdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcredentialcourse.customerupdate.dao.UserDao;
import com.microcredentialcourse.regdlogin.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.ApiOperation;
/**
 * 
 * @author javacloudmc449
 *
 */
@RestController
@RequestMapping("/v1/customerupdate")
public class CustomerController {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 
	 * @param newUser
	 * @param regd_id
	 * @return
	 */
	
	@HystrixCommand(fallbackMethod="breaker")
	@PutMapping("/{regd_id}")
	@ApiOperation(value = "Use this to update the customer details")
	public User updateCustomer(@RequestBody User newUser, @PathVariable int regd_id) {
			if(newUser==null) {
				throw new RuntimeException();
			}
		return userDao.findById(regd_id).map(cust -> {
			cust.setAddress(newUser.getAddress());
		    cust.setCountry(newUser.getCountry());
			cust.setEmailId(newUser.getEmailId());
			cust.setPhoneNum(newUser.getPhoneNum());
			cust.setState(newUser.getState());
			cust.setUserName(newUser.getUserName());
			
			return userDao.save(cust);
		}).orElseGet(() -> {
			newUser.setRegd_id(regd_id);
			return userDao.save(newUser);

		});

	}
	/**
	 * Circuit Breaker gets accessed if Update fails
	 * @param newUser
	 * @param regd_id
	 * @return
	 */
	public User breaker(@RequestBody User newUser, @PathVariable int regd_id) {
		
		return newUser;
		
	}
	
	

}
