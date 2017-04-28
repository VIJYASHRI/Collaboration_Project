package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UserDao;
import com.niit.model.User;
import com.niit.model.Error;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user){
		//client will send only username, password, email, role 
		try{
		
		user.setEnabled(true);
		user.setOnline(false);
		User savedUser=userDao.registerUser(user);
		
		return new ResponseEntity<User>(savedUser,HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			Error error=new Error(2,"Couldnt insert user details. Cannot have null/duplicate values " + e.getMessage());
			return new ResponseEntity<Error>(error , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
