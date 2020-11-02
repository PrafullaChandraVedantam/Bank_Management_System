package com.microcredentialcourse.regdlogin.dao;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.microcredentialcourse.regdlogin.model.User;

/**
 * 
 * @author javacloudmc449
 *
 */

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findByUserName(String userName);

	User findByPassword(String password);

	

}