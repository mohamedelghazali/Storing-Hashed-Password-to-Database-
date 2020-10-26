/**
 * 
 */
package com.devglan.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.UserDao;
import com.devglan.model.User;
import com.devglan.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public void save(User user) {
		user.setPassword(hashPassword(user.getPassword()));
		userDao.save(user);
	}
	
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	public User getUser(Long id) {
		return userDao.findUser(id);

	}

}
