package com.tweetapp.tweet.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LikeTest {

	
	@Test
	public void allGetterandsettertest()
	{
		Like like=new Like();
		like.setId(1);
		like.setUsername("test");
		like.setTweet(new Tweet());
		Assertions.assertEquals(like.getId(), 1);
		Assertions.assertEquals(like.getUsername(), "test");
		Assertions.assertNotNull(like.getTweet());
	}
}
