package com.tweetapp.tweet.Controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.tweetapp.tweet.payloads.GetallComment;
import com.tweetapp.tweet.service.ICommentService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

public class CommentControllerTest {

	@Mock
	ICommentService commentService;
	
	@InjectMocks
	CommentController commentController;
	
	@Test
	public void replytoTweetTest()
	{
		when(commentService.replyToTweet(null, null, 0)).thenReturn("test");
		Assertions.assertNotNull(commentController.replytoTweet(null, 0, null));
	}
	
	@Test
	public void getallreplyTest()
	{
		List<GetallComment> list=new ArrayList<GetallComment>();
		when(commentService.getallcomment(0)).thenReturn(list);
		Assertions.assertNotNull(commentController.getallreply(0));
	}
	@Test
	public void getallreplyTest2()
	{
		GetallComment getallComment=new GetallComment();
		List<GetallComment> list=new ArrayList<GetallComment>();
		list.add(getallComment);
		when(commentService.getallcomment(0)).thenReturn(list);
		Assertions.assertNotNull(commentController.getallreply(0));
	}
}
