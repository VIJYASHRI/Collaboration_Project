package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.FriendDao;
import com.niit.model.User;
import com.niit.model.Error;
import com.niit.model.Friend;

@Controller
public class FriendController {
	@Autowired
	private FriendDao friendDao;
	@Autowired
	private User user;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers(HttpSession session) {

		User user = (User) session.getAttribute("user");
		System.out.println("getting all User");

		if (user == null) {
			Error error = new Error(1, "Unauthroized user");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}

		List<User> users = friendDao.getSuggestedUsers(user);
		System.out.println("list of users");
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);

	}

	@RequestMapping(value = "/friendRequest/{to}", method = RequestMethod.PUT)
	public ResponseEntity<?> friendRequest(@PathVariable String to, HttpSession session) {
		User user = (User) session.getAttribute("user");

		if (user == null) {
			Error error = new Error(1, "Unauthroized user");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}
		friendDao.friendRequest(user.getUsername(), to);
		System.out.println("friend request to");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/pendingRequests", method = RequestMethod.GET)
	public ResponseEntity<?> pendingRequests(HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println("friend req pendng");
		if (user == null) {
			Error error = new Error(1, "Unauthroized user");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}
		List<Friend> pendingRequests = friendDao.pendingRequests(user.getUsername());
		return new ResponseEntity<List<Friend>>(pendingRequests, HttpStatus.OK);

	}

	@RequestMapping(value = "/updatependingrequest/{from}/{status}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatependingrequest(@PathVariable String from, @PathVariable char status,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println("friend req from");
		if (user == null) {
			Error error = new Error(1, "Unauthroized user");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}
		friendDao.updatependingrequest(from, user.getUsername(), status);
		System.out.println("friend2 req from");
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "/friendslist", method = RequestMethod.GET)
	public ResponseEntity<?> getAllFriends(HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println("friend list");
		if (user == null) {
			Error error = new Error(1, "Unauthroized user");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}
		List<Friend> friends = friendDao.listOfFriends(user.getUsername());
		System.out.println("friend2 list");
		return new ResponseEntity<List<Friend>>(friends, HttpStatus.OK);
	}
}
