package com.microcredentialcourse.loandetails;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.microcredentialcourse.loandetails.controller.LoanController;
import com.microcredentialcourse.loandetails.dao.LoanDao;
import com.microcredentialcourse.loandetails.model.Loan;
import com.microcredentialcourse.loandetails.model.User;
import com.microcredentialcourse.loandetails.service.LoanServiceImpl;

@SpringBootTest
class LoandetailsApplicationTests {

	@InjectMocks
	LoanServiceImpl serviceImpl;
	@InjectMocks
	LoanController loancont;

	@Mock
	LoanDao loanDao;

	@Test
	void testApplication() {
		LoandetailsApplication.main(
				new String[] { "--spring.main.web-environment=false", "--spring.autoconfigure.exclude=blahblahblah",

				});
	}

	@Test
	void testloan() {
		com.microcredentialcourse.loandetails.model.User u1 = new com.microcredentialcourse.loandetails.model.User();

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
		Loan l = new Loan();
		l.setCustomer(u1);
		l.setDate("11-01-2020");
		l.setDurationOfLoan("65");
		l.setLoanAmount(200000L);
		l.setLoanId(1);
		l.setLoanType("personal");
		l.setRateOfInterest("3.5");

		Loan l1 = new Loan();
		l1 = serviceImpl.applyLoan(l);
		// assertThat(l1).isNotNull();

	}

	@Test
	void testbreaker() {
		Loan l = new Loan();
		User cust = new User();
		l = loancont.breaker(null);
	}

	@Test
	void testbreaker1() {
		Loan l = null;
		User cust = new User();
		loancont.breaker(l);
	}

	@Test
	void testbreaker2() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Loan l = new Loan();
			Loan l1 = new Loan();
			Loan l2 = new Loan();
			User cust = new User();
			l.setCustomer(cust);

			// l1= serviceImpl.applyLoan(l);
			l1 = loancont.applyLoan(l);
		});

	}

}
