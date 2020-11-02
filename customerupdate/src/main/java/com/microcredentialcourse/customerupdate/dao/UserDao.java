package com.microcredentialcourse.customerupdate.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microcredentialcourse.regdlogin.model.SignUpDto;
import com.microcredentialcourse.regdlogin.model.User;
/**
 * 
 * @author javacloudmc449
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	SignUpDto save(SignUpDto customer1);

	
}