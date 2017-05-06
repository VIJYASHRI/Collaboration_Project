package com.niit.collaboration.project2_backend;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.User;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.PerfectShop.dao.UserDAO;
import com.niit.PerfectShop.domain.User;

public class UserTest {

	@ Autowired static AnnotationConfigApplicationContext context;
	@Autowired static UserDao userDAO;
	  @Autowired static User user;
	  
	  public static void initialize()
	  {
	   context=new AnnotationConfigApplicationContext();
	   context.scan("com.niit.PerfectShop");
	   context.refresh();
	   userDAO=(UserDAO)context.getBean("userDAO");
	   user=(User)context.getBean("user");
	  }
	  @Test
	  public void createUserTestCase()
	  {
	  user.setId("104"); 
	  user.setUsername("shobhit Singh");
	  user.setPassword("shobhit");
	  //user.setContact("9555778866");
	  user.setRole("seller");
	  boolean flag=userDAO.save(user);
	  assertEquals("createUserTestCase", true,flag);
	  
	  
	  
	  
	  }
	  /*//@Test
	  public void updateUserTestCase()
	  {
	  user.setId("101"); 
	  user.setName("Pawan Singh");
	  user.setPassword("pawan@123");
	  user.setContact("9555668855");
	  user.setRole("user");
	  boolean flag=userDAO.update(user);
	  assertEquals("updateUserTestCase", true,flag);
	  }
	  //@Test
	  public void validateUserTestCase()
	  {
	  boolean flag=userDAO.validate("101", "pawan@123");
	  assertEquals(true,flag);
	  }
	  @Test
	  public void getAllUserTestCase()
	  {
	  int actSize=userDAO.lists().size();
	  assertEquals(2,actSize);
	  }
	  //@Test
	  public void getRecord()
	  {
	  User details=userDAO.get("103");
	  System.out.println(details.getName());
	  assertEquals("shobhit singh", details.getName());
	        assertEquals("9555778866", details.getContact());
	        assertEquals("seller", details.getRole());
	  }
	  */
	/*public static void main(String[] args) {
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
*/
}
