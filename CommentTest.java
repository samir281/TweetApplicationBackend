package com.tweetapp.tweet.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentTest {

	@Test
	public void allGetterandSetterTest()
	{
		Comment comment =new Comment();
		comment.setDate(null);
		comment.setId(1);
		comment.setReply("test");
		comment.setTweet(new Tweet());
		comment.setUserName("test");
		
		Assertions.assertEquals(comment.getId(),1);
		Assertions.assertEquals(comment.getDate(), null);
		Assertions.assertEquals(comment.getReply(), "test");
		Assertions.assertEquals(comment.getUserName(), "test");
		Assertions.assertNotNull(comment.getTweet());
	}
}
