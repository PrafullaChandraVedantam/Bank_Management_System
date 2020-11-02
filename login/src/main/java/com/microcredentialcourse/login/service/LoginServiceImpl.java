package com.microcredentialcourse.login.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.microcredentialcourse.login.dao.LoginDao;
import com.microcredentialcourse.login.model.LoginDto;
import com.microcredentialcourse.regdlogin.model.ApiResponse;
import com.microcredentialcourse.regdlogin.model.User;

/**
 * 
 * @author javacloudmc449
 *
 */
@Transactional
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDao userDao;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public ApiResponse login(LoginDto loginDto) {
		User user = userDao.findByUserName((loginDto.getUserName()));
		if (user == null) {
			throw new RuntimeException("Customer does not exist.");
		}
		
		if (!user.getPassword().equals((loginDto.getPassword()))) {
		//if(passwordEncoder.matches(loginDto.getPassword(),user.getPassword() )) {
			throw new RuntimeException("Password mismatch.");
		}
		return new ApiResponse(200, "Login success", null);

	}
	

}
