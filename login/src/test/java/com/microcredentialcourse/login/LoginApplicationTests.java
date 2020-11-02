package com.microcredentialcourse.login;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.microcredentialcourse.login.controller.LoginController;
import com.microcredentialcourse.login.dao.LoginDao;
import com.microcredentialcourse.login.model.LoginDto;
import com.microcredentialcourse.login.service.LoginServiceImpl;
import com.microcredentialcourse.regdlogin.RegdloginApplication;
import com.microcredentialcourse.regdlogin.controller.UserController;
import com.microcredentialcourse.regdlogin.dao.UserDao;
import com.microcredentialcourse.regdlogin.dao.UserDaoImpl;
import com.microcredentialcourse.regdlogin.model.ApiResponse;
import com.microcredentialcourse.regdlogin.model.SignUpDto;
import com.microcredentialcourse.regdlogin.model.User;
import com.microcredentialcourse.regdlogin.service.UserServiceImpl;

@SpringBootTest
class LoginApplicationTests {
	@InjectMocks
	UserServiceImpl serviceImpl;
	
	@InjectMocks
	LoginServiceImpl loginserviceImpl;
	
	
	
	@InjectMocks
	UserController ucon;
	
	@InjectMocks
	LoginController logincont;

	@Mock
	UserDaoImpl daoImpl;
	@Mock
	UserDao userDao;
	
	@Mock
	LoginDao loginDao;

	@Test
	void testlogin() {
		User u = new User(99, "nadh", "Prafu@29", "nadh@gmail.com", "dsnr", 2213726038414410L, "ts", "Ind",
				"7711223344", "KHFVC12345", "sb");
		SignUpDto s = new SignUpDto("nadh", "Prafu@29", "nadh@gmail.com", "dsnr", "ts", "Ind", "7711223344",
				"KHFVC12345", "sb");
		when(userDao.save(u)).thenReturn(u);
		LoginDto login = new LoginDto("nadh","Prafu@29");
		//ApiResponse re = loginserviceImpl.login(login);
	//	ApiResponse re1 = logincont.login(login);
		
	//	assertThat(re).isNotNull();
		
	}
	@Test
	void testbreaker() {
		User u = new User(99, "n", "Prafu@29", "nadh@gmail.com", "dsnr", 2213726038414410L, "ts", "Ind",
				"7711223344", "KHFVC12345", "sb");
		SignUpDto s = new SignUpDto("n", "Prafu@29", "nadh@gmail.com", "dsnr", "ts", "Ind", "7711223344",
				"KHFVC12345", "sb");
		when(userDao.save(u)).thenReturn(u);
		LoginDto login = new LoginDto("n","Prafu@29");
		ApiResponse re = logincont.breaker(login);
		assertThat(re).isNotNull();
		
	}
	
	@Test
	void testlogin1() {
		User u = new User(99, "nadh", "Prafu@29", "nadh@gmail.com", "dsnr", 2213726038414410L, "ts", "Ind",
				"7711223344", "KHFVC12345", "sb");
		SignUpDto s = new SignUpDto("nadh", "Prafu@29", "nadh@gmail.com", "dsnr", "ts", "Ind", "7711223344",
				"KHFVC12345", "sb");
		when(userDao.save(u)).thenReturn(u);
		LoginDto login = new LoginDto();
		login.setUserName("nadh");
		login.setPassword("Prafu@29");
		ApiResponse re = logincont.login(login);
				
		
	
			}
	
	@Test
	void testlogin2()  throws Exception{
		
		User u = new User();
		SignUpDto s = new SignUpDto();
		when(userDao.save(u)).thenReturn(u);
		LoginDto login = new LoginDto();
		ApiResponse re = loginserviceImpl.login(login);
		
		
		
	
	}
	@Test
    void testApplication()
    {
        LoginApplication.main(new String[]{
                "--spring.main.web-environment=false",
                "--spring.autoconfigure.exclude=blahblahblah",
               
        });
    }

}
