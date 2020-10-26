package com.devglan.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devglan.dao.UserDao;
import com.devglan.model.User;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		sessionFactory.openSession().save(user);
	}

	public User findUser(Long id) {
		return (User) sessionFactory.openSession().get(User.class, id);
	}

}
