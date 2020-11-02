package com.microcredentialcourse.login.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microcredentialcourse.regdlogin.model.User;

/**
 * 
 * @author javacloudmc449
 *
 */
@Repository
public interface LoginDao extends CrudRepository<User, Integer> {

	User findByUserName(String userName);

}
