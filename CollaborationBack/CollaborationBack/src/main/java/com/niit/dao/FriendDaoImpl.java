package com.niit.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Friend;
import com.niit.model.User;
@Repository
public class FriendDaoImpl implements FriendDao {
	@Autowired
	public SessionFactory sessionFactory;
	public List<User> getSuggestedUsers(User user) {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select * from user_batch15 where username in (select username from user_batch15 where username!=? minus (select from_id from friend_batch15 where to_id=?"
				+ "union select to_id from friend_batch15 where from_id=?"
				+ "))");
		query.setString(0, user.getUsername());
		query.setString(1, user.getUsername());
		query.setString(2, user.getUsername());
		query.addEntity(User.class);
		List<User> users=query.list();
		session.close();
		return users;
	}

	public void friendRequest(String from, String to) {
		Session session=sessionFactory.openSession();
		Friend friend =new Friend();
		friend.setFrom(from);
		friend.setTo(to);
		friend.setStatus('P');
		session.save(friend);
		session.flush();
		session.close();
		
	}

	public List<Friend> pendingRequests(String toUsername) {
		Session session=sessionFactory.openSession();
		Friend friend =new Friend();
		friend.setFrom("from");
		friend.setTo("to");
		friend.setStatus('P');
		session.save(friend);
		session.flush();
		session.close();
		return null; //null => pendingRequest
	}

}
