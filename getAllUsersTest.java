package com.tweetapp.tweet.payloads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class getAllUsersTest {
	
	@Test
	public void allGetterSetterTest()
	{
		GetAllUsers getAllUsers=new GetAllUsers();
		getAllUsers.setFirstname("test");
		getAllUsers.setLastname("test");
		getAllUsers.setId(1);
		getAllUsers.setUsername("test");
		Assertions.assertEquals(getAllUsers.getFirstname(),"test");
		Assertions.assertEquals(getAllUsers.getLastname(),"test");
		Assertions.assertEquals(getAllUsers.getUsername(),"test");
		Assertions.assertEquals(getAllUsers.getId(),1);
	}

}
