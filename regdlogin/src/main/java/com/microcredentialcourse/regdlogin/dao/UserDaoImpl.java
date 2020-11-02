package com.microcredentialcourse.regdlogin.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microcredentialcourse.regdlogin.model.User;

/**
 * 
 * @author javacloudmc449
 *
 */
@Repository
public class UserDaoImpl {

	@Autowired
	private EntityManager em;

	public User save(User user) {
		Session session = em.unwrap(Session.class);
		session.persist(user);
		return user;
	}
	
	


}