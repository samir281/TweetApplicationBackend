package com.tweetapp.tweet.payloads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserLoginTest {
	
	@Test
	public void allGetterSetterTest()
	{
		UserLogin userLogin=new UserLogin();
		userLogin.setPassword("test");
		userLogin.setUsername("test");
		
		Assertions.assertEquals(userLogin.getPassword(), "test");
		Assertions.assertEquals(userLogin.getUsername(), "test");
	}

}
