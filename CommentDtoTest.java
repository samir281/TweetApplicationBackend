package com.tweetapp.tweet.payloads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentDtoTest {

	@Test
	public void getterAndSetterTest()
	{
		CommentDto commentDto=new CommentDto();
		commentDto.setReply("test");
		
		Assertions.assertEquals(commentDto.getReply(), "test");
	}
}
