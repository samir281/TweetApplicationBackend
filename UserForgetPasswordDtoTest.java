package com.tweetapp.tweet.payloads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserForgetPasswordDtoTest {

	
	@Test
	public void allGetterSetterTest()
	{
		UserForgetPasswordDto userForgetPasswordDto=new UserForgetPasswordDto();
		userForgetPasswordDto.setNewpassword("test");
		userForgetPasswordDto.setPhonenumber("0987654321");
		userForgetPasswordDto.setUsername("test");
		
		Assertions.assertEquals(userForgetPasswordDto.getNewpassword(), "test");
		Assertions.assertEquals(userForgetPasswordDto.getUsername(), "test");
		Assertions.assertEquals(userForgetPasswordDto.getPhonenumber(), "0987654321");
	}
}
