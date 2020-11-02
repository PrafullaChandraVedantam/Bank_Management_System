package com.microcredentialcourse.loandetails.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcredentialcourse.loandetails.LoandetailsApplication;
import com.microcredentialcourse.loandetails.model.Loan;
import com.microcredentialcourse.loandetails.service.LoanService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/v1")
public class LoanController {

	@Autowired
	LoanService loanService;

	public static final Logger logger = LoggerFactory.getLogger(LoandetailsApplication.class);
	@HystrixCommand(fallbackMethod = "breaker")
	@PostMapping(path = "/applyLoan")
	public Loan applyLoan(@Valid @RequestBody Loan loan) {
		if(loan==null) {
			throw new RuntimeException();
		}
		logger.info("Received Loan details to insert in Db");
		return loanService.applyLoan(loan);
	}
	public Loan breaker(@Valid @RequestBody Loan loan) {
		return null;
	}
	

}
