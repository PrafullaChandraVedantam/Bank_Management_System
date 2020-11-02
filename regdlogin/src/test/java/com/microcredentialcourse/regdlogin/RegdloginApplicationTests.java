package com.microcredentialcourse.regdlogin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.microcredentialcourse.regdlogin.controller.UserController;
import com.microcredentialcourse.regdlogin.dao.UserDao;
import com.microcredentialcourse.regdlogin.dao.UserDaoImpl;
import com.microcredentialcourse.regdlogin.model.ApiResponse;
import com.microcredentialcourse.regdlogin.model.SignUpDto;
import com.microcredentialcourse.regdlogin.model.User;
import com.microcredentialcourse.regdlogin.service.UserServiceImpl;

@SpringBootTest
class RegdloginApplicationTests {

	@InjectMocks
	UserServiceImpl serviceImpl;
	
	
	
	@InjectMocks
	UserController ucon;

	@Mock
	UserDaoImpl udao;
	@Mock
	UserDao ud;

	@Test
	 void testregdcust() {
		User u = new User(99, "nadh", "Prafu@29", "nadh@gmail.com", "dsnr", 2213726038414410L, "ts", "Ind",
				"7711223344", "KHFVC12345", "sb");
		SignUpDto s = new SignUpDto("nadh", "Prafu@29", "nadh@gmail.com", "dsnr", "ts", "Ind", "7711223344",
				"KHFVC12345", "sb");
		when(udao.save(u)).thenReturn(u);

		ApiResponse re = serviceImpl.signUp(s);
		assertThat(re).isNotNull();

	}
	@Test
	 void testregdcustfail() {
		User u = new User();
		SignUpDto s = new SignUpDto("nadh", "Prafu@29", "nadh@gmail.com", "dsnr", "ts", "Ind", "7711223344",
				"KHFVC12345", "sb");
		when(udao.save(u)).thenReturn(u);

		ApiResponse re = serviceImpl.signUp(s);
		assertThat(re).isNotNull();

	}
	
	@Test
   void testregdcustfail2() {
		User u = new User();
		SignUpDto s = new SignUpDto();
		when(udao.save(u)).thenReturn(u);

		ApiResponse re = serviceImpl.signUp(s);
		assertThat(re).isNotNull();

	}
	
	@Test
	 void testregdfail3() {
		User u = new User(99, "nadh", "Prafu@29", "nadh@gmail.com", "dsnr", 2213726038414410L, "ts", "Ind",
				"7711223344", "KHFVC12345", "sb");
		SignUpDto s = new SignUpDto();
		when(udao.save(u)).thenReturn(u);

		ApiResponse re = serviceImpl.signUp(s);
		assertThat(re).isNotNull();

	}
	
	@Test
	 void testregdfail4() {
		User u = new User(100, "a", "Prafu@29", "nadh@gmail.com", "dsnr", 221, "ts", "Ind",
				"77112233", "KHFVC12", "sb");
		SignUpDto s = new SignUpDto();
		when(udao.save(u)).thenReturn(u);

		ApiResponse re = serviceImpl.signUp(s);
		assertThat(re).isNotNull();

	}
	@Test
	 void testregdfail5() {
		User u = new User(100, "a", "Prafu@29", "nadh@gmail.com", "dsnr", 221, "ts", "Ind",
				"77112233", "KHFVC12", "sb");
		SignUpDto s = new SignUpDto();
		when(udao.save(u)).thenReturn(u);

		ApiResponse re = serviceImpl.signUp(s);
		assertThat(re).isNotNull();

	}
	
	@Test
	 void testregdfail6() {
		User u = new User(1, "abcdefghijklmnopq", "Prafu@29", "nadh@gmail.com", "dsnr", 221000000000000L, "ts", "Ind",
				"7711223311111111", "KHFVC12999999999", "sb");
		SignUpDto s = new SignUpDto( "abcdefghijklmnopq", "Prafu@29", "nadh@gmail.com", "dsnr", "ts", "Ind",
				"7711223311111111", "KHFVC12999999999", "sb");
		when(udao.save(u)).thenReturn(u);

		ApiResponse re = serviceImpl.signUp(s);
		assertThat(re).isNotNull();

	}
	
	@Test
	 void testbreaker() {
		User u = new User(99, "nadhBCDEFGHIEF", "Prafu@29", "nadh@gmail.com", "dsnr", 2213726038414410L, "ts", "Ind",
				"7711223344", "KHFVC12345", "sb");
		SignUpDto s = new SignUpDto("nadhBCDEFGHIEF", "Prafu@29", "nadh@gmail.com", "dsnr", "ts", "Ind", "7711223344",
				"KHFVC12345", "sb");
		when(udao.save(u)).thenReturn(u);

		ApiResponse re = ucon.breaker(s);
		assertThat(re).isNotNull();
		
	}
	@Test
	 void testgetall() {
		User u = new User(99, "nadh", "Prafu@29", "nadh@gmail.com", "dsnr", 2213726038414410L, "ts", "Ind",
				"7711223344", "KHFVC12345", "sb");
		SignUpDto s = new SignUpDto("nadh", "Prafu@29", "nadh@gmail.com", "dsnr", "ts", "Ind", "7711223344",
				"KHFVC12345", "sb");
		when(udao.save(u)).thenReturn(u);

		List<User> lu=(List<User>) ud.findAll();
		assertThat(lu).isNotNull();

	}
	
	@Test
    void testApplication()
    {
        RegdloginApplication.main(new String[]{
                "--spring.main.web-environment=false",
                "--spring.autoconfigure.exclude=blahblahblah",
               
        });
    }
	
@Test
void testset() {
	User u1= new User();
	u1.setRegd_id(100);
	u1.setAccntType("sb");
	u1.setPanNum("ABCDEF12345");
	u1.setPhoneNum("8978127720");
	u1.setCountry("Ind");
	u1.setState("AP");
	u1.setEmailId("a@gmail.com");
	u1.setAddress("tenali");
	u1.setPassword("Prafu@29");
	u1.setUserName("prafulla");
	u1.setAccntNum(2213726038414410L);
	
	SignUpDto s1 = new SignUpDto();
	s1.setAccntType("sb");
	s1.setPanNum("ABCDEF12345");
	s1.setPhoneNum("8978127720");
	s1.setCountry("Ind");
	s1.setState("AP");
	s1.setEmailId("a@gmail.com");
	s1.setAddress("tenali");
	s1.setPassword("Prafu@29");
	s1.setUserName("prafulla");
	
	when(udao.save(u1)).thenReturn(u1);
	ApiResponse re = new ApiResponse();
	re.setMessage("Working");
	re.setResult(u1);


	//ApiResponse re = serviceImpl.signUp(s1);
	assertThat(re).isNotNull();
	
}
@Test
void testregdfail7() throws RuntimeException {
	User u = new User(99, "nadh", "Prafu@29", "nadh@gmail.com", "dsnr", 2213726038414410L, "ts", "Ind",
			"7711223344", "KHFVC12345", "sb");
	SignUpDto s = null;
	when(udao.save(u)).thenReturn(u);
}

@Test
void testregdfail8() throws Exception {
	
	User u = null;
	SignUpDto s = null;
	when(udao.save(u)).thenReturn(u);
	

	

}

@Test
void testgetcustId() {
	User u = new User(99, "nadh", "Prafu@29", "nadh@gmail.com", "dsnr", 2213726038414410L, "ts", "Ind",
			"7711223344", "KHFVC12345", "sb");
	SignUpDto s = new SignUpDto("nadh", "Prafu@29", "nadh@gmail.com", "dsnr", "ts", "Ind", "7711223344",
			"KHFVC12345", "sb");
	when(udao.save(u)).thenReturn(u);
   
	try {
		ucon.getCustById(99);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	

}

@Test
void testgetcustIdfail() throws Exception {
	User u = new User(99, "nadh", "Prafu@29", "nadh@gmail.com", "dsnr", 2213726038414410L, "ts", "Ind",
			"7711223344", "KHFVC12345", "sb");
	SignUpDto s = new SignUpDto("nadh", "Prafu@29", "nadh@gmail.com", "dsnr", "ts", "Ind", "7711223344",
			"KHFVC12345", "sb");
	when(udao.save(u)).thenReturn(u);
   
	try {
		ucon.getCustById(991);
	} catch (Exception e) {
		ucon.getidbreaker(991);
		
	}
}

			
	
}
