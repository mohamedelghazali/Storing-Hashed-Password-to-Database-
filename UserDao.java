package com.devglan.dao;

import com.devglan.model.User;

public interface UserDao {

	void save(User user);

	User findUser(Long id);


}
