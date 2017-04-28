package com.niit.collaboration.project2_backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.User;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		User user = (User)context.getBean("user");
		
		UserDao dao=(UserDao)context.getBean("userDao");
		
		user.setEmail("abc@gmail.com");
		user.setEnabled(true);
		user.setOnline(false);
		user.setPassword("abc");
		user.setRole("Admin");
		user.setUsername("abc");
		
		dao.registerUser(user);
		System.out.println("User Added");
	}

}
