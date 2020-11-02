package com.microcredentialcourse.loandetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microcredentialcourse.loandetails.model.Loan;

public interface LoanDao extends JpaRepository<Loan, Long> {

}
