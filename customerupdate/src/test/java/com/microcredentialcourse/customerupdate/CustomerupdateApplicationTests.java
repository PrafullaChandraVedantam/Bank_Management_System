package com.microcredentialcourse.customerupdate;

import static org.mockito.Mockito.when;

import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.microcredentialcourse.customerupdate.controller.CustomerController;
import com.microcredentialcourse.customerupdate.dao.UserDao;
import com.microcredentialcourse.regdlogin.dao.UserDaoImpl;
import com.microcredentialcourse.regdlogin.model.SignUpDto;
import com.microcredentialcourse.regdlogin.model.User;
import com.microcredentialcourse.regdlogin.service.UserServiceImpl;

@SpringBootTest
class CustomerupdateApplicationTests {
	@InjectMocks
	UserServiceImpl serviceImpl;
	
	
	
	@InjectMocks
	CustomerController custcontroller;

	@Mock
	UserDaoImpl udaoImpl;
	@Mock
	UserDao udao;

    @Test
    public void testcustupdate(){
    	User u = new User(99, "nadh", "Prafu@29", "nadh@gmail.com", "dsnr", 2213726038414410L, "ts", "Ind",
				"7711223344", "KHFVC12345", "sb");
    	SignUpDto s = new SignUpDto("nadh", "Prafu@29", "nadh@gmail.com", "dsnr", "ts", "Ind", "7711223344",
				"KHFVC12345", "sb");
		when(udao.save(u)).thenReturn(u);
		
		custcontroller.updateCustomer(u, 99);
		custcontroller.breaker(null, 99);
	    User cust = new User();
				cust.setAddress("address");
			    cust.setCountry("country");
				cust.setEmailId("email@yahoo.com");
				cust.setPhoneNum("1234567891");
				cust.setState("state");
				cust.setUserName("username");
				
				udao.save(cust); 
			

			User customer =custcontroller.updateCustomer(cust, 99);
			custcontroller.breaker(null, -1);
	     
	     
	     
	     
			
      
 //         assertEquals(11, customer.getRegd_id());
//          assertEquals("nadh", customer.getUserName());
//          assertEquals("Prafu@29", customer.getPassword());
//          assertEquals( "nadh@gmail.com", customer.getEmailId());
//          assertEquals("dnsr",customer.getAddress());
//          assertEquals("ap", customer.getState());
//          assertEquals("india", customer.getCountry());
//          assertEquals(2264270734483823L, customer.getAccntNum());
//          assertEquals("POIUY12345", customer.getPanNum());
//          assertEquals("6677554433", customer.getPhoneNum());
//          assertEquals("savings", customer.getAccntType());
//      
    }
    
    @Test
    void testApplication()
    {
        CustomerupdateApplication.main(new String[]{
                "--spring.main.web-environment=false",
                "--spring.autoconfigure.exclude=blahblahblah",
               
        });
    }



}


