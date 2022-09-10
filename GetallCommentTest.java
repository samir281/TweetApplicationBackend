package com.tweetapp.tweet.payloads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetallCommentTest {

	@Test
	public void allGetterSetterTest()
	{
		GetallComment getallComment=new GetallComment();
		getallComment.setDate(null);
		getallComment.setId(1);
		getallComment.setReply("test");
		getallComment.setUserName("test");
		
		Assertions.assertEquals(getallComment.getId(), 1);
		Assertions.assertEquals(getallComment.getDate(), null);
		Assertions.assertEquals(getallComment.getReply(), "test");
		Assertions.assertEquals(getallComment.getUserName(), "test");
	}
}
