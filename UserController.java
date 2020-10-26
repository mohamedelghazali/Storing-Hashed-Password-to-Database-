package com.devglan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devglan.model.User;
import com.devglan.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User user) {
		userService.save(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable(value = "id")Long userId) {
        
		User user = userService.getUser(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
