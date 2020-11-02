package com.microcredentialcourse.regdlogin.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microcredentialcourse.regdlogin.dao.UserDaoImpl;
import com.microcredentialcourse.regdlogin.model.ApiResponse;
import com.microcredentialcourse.regdlogin.model.SignUpDto;
import com.microcredentialcourse.regdlogin.model.User;

/**
 * 
 * @author javacloudmc449
 *
 */

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl userDaoImpl;

	@Override
	public ApiResponse signUp(SignUpDto signUpDto) {

		User user = new User();
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//signUpDto.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
		BeanUtils.copyProperties(signUpDto, user);
		userDaoImpl.save(user);
		return new ApiResponse(200, "success", user);
	}
  
}
