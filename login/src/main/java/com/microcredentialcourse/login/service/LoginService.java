package com.microcredentialcourse.login.service;

import com.microcredentialcourse.login.model.LoginDto;
import com.microcredentialcourse.regdlogin.model.ApiResponse;

public interface LoginService {
	ApiResponse login(LoginDto loginDto);
}
