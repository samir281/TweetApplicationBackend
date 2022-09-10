package com.tweetapp.tweet.entity;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
	@Test
	public void allGetterAndSetterTest()
	{
		User user=new User();
		user.setId(1);
		user.setFirstname("test");
		user.setLastName("test");
		user.setMiddlename("test");
		user.setPassword("test");
		user.setUsername("test");
		List<Tweet> listTweet=new ArrayList<Tweet>();
		user.setTweetJpaList(listTweet);
		user.setPhoneNumber("0987654321");
		String result="test";
		Assertions .assertEquals(user.getFirstname(), result);
		Assertions.assertEquals(user.getLastName(), result);
		Assertions.assertEquals(user.getMiddlename(), result);
		Assertions.assertEquals(user.getPassword(), result);
		Assertions.assertEquals(user.getUsername(), result);
		Assertions.assertEquals(user.getPhoneNumber(), "0987654321");
		Assertions.assertEquals(user.getId(), 1);
		Assertions.assertNotNull(user.getTweetJpaList());
	}
	@Test
	public void allArgsContructorTest()
	{
		User user=new User(1,"test","test","test","test","test","test");
		String result="test";
		Assertions.assertEquals(user.getFirstname(), result);
		Assertions.assertEquals(user.getLastName(), result);
		Assertions.assertEquals(user.getMiddlename(), result);
		Assertions.assertEquals(user.getPassword(), result);
		Assertions.assertEquals(user.getUsername(), result);
		Assertions.assertEquals(user.getPhoneNumber(), "test");
		Assertions.assertEquals(user.getId(), 1);
		List<Tweet> listTweet=new ArrayList<Tweet>();
		User user1=new User(1,"test","test","test","test","test","test",listTweet);
		Assertions.assertEquals(user1.getFirstname(), result);
		Assertions.assertEquals(user1.getLastName(), result);
		Assertions.assertEquals(user1.getMiddlename(), result);
		Assertions.assertEquals(user1.getPassword(), result);
		Assertions.assertEquals(user1.getUsername(), result);
		Assertions.assertEquals(user1.getPhoneNumber(), "test");
		Assertions.assertEquals(user1.getId(), 1);
		Assertions.assertNotNull(user1.getTweetJpaList());
	}
	
	@Test
	public void JwtTest()
	{
		User user=new User();
		Assertions.assertTrue(user.isAccountNonExpired());
		Assertions.assertTrue(user.isAccountNonLocked());
		Assertions.assertTrue(user.isCredentialsNonExpired());
		Assertions.assertTrue(user.isEnabled());
	}
}
