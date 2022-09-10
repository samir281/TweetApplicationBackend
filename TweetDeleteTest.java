package com.tweetapp.tweet.payloads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TweetDeleteTest {

	@Test
	public void allGetterAndSetterTest()
	{
		TweetDelete tweetDelete=new TweetDelete();
		tweetDelete.setTweetId(1);
		tweetDelete.setUsername("test");
		
		Assertions.assertEquals(tweetDelete.getUsername(), "test");
		Assertions.assertEquals(tweetDelete.getTweetId(), 1);
	}
}
