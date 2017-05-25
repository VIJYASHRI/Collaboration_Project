package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
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
		SQLQuery query=session.createSQLQuery("select * from USER_DTBATCH15 where username in (select username from USER_DTBATCH15 where username!=? minus (select from_id from friend where to_id=?"
				+ "union select to_id from FRIEND where from_id=?"
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
		Query query=session.createQuery("from Friend where to=? and from=?");
		query.setString(0,toUsername);
		query.setCharacter(1,'P');
		List<Friend> pendingRequests=query.list();
		session.close();
		return pendingRequests;
}

	@Override
	public void updatependingrequest(String from, String username, char status) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("Update Friend set Status=? where from=? and to=?");
		query.setCharacter(0, status);
		query.setString(1, from);
		query.setString(2,username);
		int count=query.executeUpdate();
		System.out.println("Number of records updated" + count);
		session.close();
		session.flush();
		
	}
public List<Friend> listOfFriends(String username) {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("");
	query.setString(0, username);
	query.setString(1, username);
	List<Friend> friends=query.list();
	session.close();
	session.flush();
	return null;
}
	
}