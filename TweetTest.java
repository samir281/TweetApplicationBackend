package com.tweetapp.tweet.entity;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TweetTest {

	
	@Test
	public void allgetterandsetterTest()
	{
		Tweet tweet=new Tweet();
		tweet.setDescription("test");
		tweet.setId(1);
		tweet.setDate(new Date());
		tweet.setLike(null);
		tweet.setUser(null);
		tweet.setComments(null);
		Assertions.assertEquals(tweet.getDescription(), "test");
		Assertions.assertNull(tweet.getComments());
		Assertions.assertNull(tweet.getLike());
		Assertions.assertNull(tweet.getUser());
		Assertions.assertEquals(tweet.getId(), 1);
		Assertions.assertNotNull(tweet.getDate());
	}
}
