package com.microcredentialcourse.loandetails.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microcredentialcourse.loandetails.LoandetailsApplication;
import com.microcredentialcourse.loandetails.dao.LoanDao;
import com.microcredentialcourse.loandetails.model.Loan;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanDao loanRepository;

	public static final Logger logger = LoggerFactory.getLogger(LoandetailsApplication.class);

	@Override
	public Loan applyLoan(Loan loan) {
		logger.info("Saving Loan details in Db");
		Loan loan1 = loanRepository.save(loan);
		logger.info("Saved Loan details in Db");
		return loan1;
	}

}
