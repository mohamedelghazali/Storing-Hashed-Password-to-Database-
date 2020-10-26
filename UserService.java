/**
 * 
 */
package com.devglan.service;

import com.devglan.model.User;

public interface UserService {

	void save(User user);

	User getUser(Long userId);

}
