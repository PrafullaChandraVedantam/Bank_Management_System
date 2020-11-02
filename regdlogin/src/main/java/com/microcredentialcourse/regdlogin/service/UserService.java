package com.microcredentialcourse.regdlogin.service;

import com.microcredentialcourse.regdlogin.model.ApiResponse;
import com.microcredentialcourse.regdlogin.model.SignUpDto;

public interface UserService {

	ApiResponse signUp(SignUpDto signUpDto);

}
