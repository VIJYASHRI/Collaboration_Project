package com.niit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

@Repository(value = "userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	public User registerUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user;
	}

	public User login(User user) {
		//Session session = sessionFactory.openSession();
		// select * from user_batch15 where username=user.getUsername() and
		// password=user.getPassword()
		//Query query = session.createQuery("from User where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'"); // from user where username='john' and password='123'
		//User validUser = (User) query.uniqueResult();
		//return validUser;
		String query="from User where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		return (User) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
	}

	public void updateUser(User user) {
		Session session = sessionFactory.openSession();
		// update user_batch15 set
		// username=?,password=?,email=?,enabled=?,online=? where id=?
		session.update(user);
		session.flush();
		session.close();
	}

	public User getUser(int id) {
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class, id);
		session.close();
		return user;
	}

}
