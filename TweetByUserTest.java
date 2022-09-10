package com.tweetapp.tweet.payloads;

 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TweetByUserTest {

	
	@Test
	public void allGetterAndSetterTest()
	{
		TweetByUser tweetByUser=new TweetByUser();
		tweetByUser.setDate(null);
		tweetByUser.setDescip("test");
		tweetByUser.setId(1);
		tweetByUser.setUsername("test");
		
		Assertions.assertEquals(tweetByUser.getId(), 1);
		Assertions.assertEquals(tweetByUser.getDate(), null);
		Assertions.assertEquals(tweetByUser.getDescip(), "test");
		Assertions.assertEquals(tweetByUser.getUsername(), "test");
	}
	
	@Test
	public void allArgsTest()
	{
		TweetByUser tweetByUser=new TweetByUser(1,"test","test",null);

		Assertions.assertEquals(tweetByUser.getId(), 1);
		Assertions.assertEquals(tweetByUser.getDate(), null);
		Assertions.assertEquals(tweetByUser.getDescip(), "test");
		Assertions.assertEquals(tweetByUser.getUsername(), "test");
	}
}
