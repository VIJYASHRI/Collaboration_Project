package com.niit.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogDao;
import com.niit.model.BlogPost;
import com.niit.model.User;
import com.niit.model.Error;

@RestController
public class BlogPostController {
	
	@Autowired
	private BlogDao blogDao;

	@RequestMapping(value = "/saveBlogPost", method = RequestMethod.POST)
	public ResponseEntity<?> saveBlogPost(@RequestBody BlogPost blogPost, HttpSession session) {

		User user = (User) session.getAttribute("user");
		if (user == null) {
			Error error = new Error(3, "Unauthorized user");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		} else {
			blogPost.setCreatedBy(user);
			blogPost.setCreatedOn(new Date());
			blogDao.saveBlogPost(blogPost);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

	}
}