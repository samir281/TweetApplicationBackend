package com.tweetapp.tweet.payloads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserDTOTest {
	@Test
	public void allGetterAndSetterTest()
	{
		UsersDto user=new UsersDto();
		user.setId(1);
		user.setFirstname("test");
		user.setLastName("test");
		user.setMiddlename("test");
		user.setPassword("test");
		user.setUsername("test");
		user.setPhoneNumber("0987654321");
		String result="test";
		Assertions .assertEquals(user.getFirstname(), result);
		Assertions.assertEquals(user.getLastName(), result);
		Assertions.assertEquals(user.getMiddlename(), result);
		Assertions.assertEquals(user.getPassword(), result);
		Assertions.assertEquals(user.getUsername(), result);
		Assertions.assertEquals(user.getPhoneNumber(), "0987654321");
		Assertions.assertEquals(user.getId(), 1);
	}
	@Test
	public void allArgsContructorTest()
	{
		UsersDto user1=new UsersDto(1,"test","test","test","test","test","test");
		String result="test";
		Assertions.assertEquals(user1.getFirstname(), result);
		Assertions.assertEquals(user1.getLastName(), result);
		Assertions.assertEquals(user1.getMiddlename(), result);
		Assertions.assertEquals(user1.getPassword(), result);
		Assertions.assertEquals(user1.getUsername(), result);
		Assertions.assertEquals(user1.getPhoneNumber(), "test");
		Assertions.assertEquals(user1.getId(), 1);
	}
	
}
