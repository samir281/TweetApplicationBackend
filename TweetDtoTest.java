package com.tweetapp.tweet.payloads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TweetDtoTest {
	
	@Test
	public void allGetterAndSetter()
	{
		TweetDto tweetDto=new TweetDto();
		tweetDto.setDiscription("test");
		tweetDto.setId(1);
		
		Assertions.assertEquals(tweetDto.getId(), 1);
		Assertions.assertEquals(tweetDto.getDiscription(), "test");
	}
	
	@Test
	public void allArgsTest()
	{
		TweetDto tweetDto=new TweetDto(1,"test");
		Assertions.assertEquals(tweetDto.getId(), 1);
		Assertions.assertEquals(tweetDto.getDiscription(), "test");
	}
	
}
