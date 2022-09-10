package com.tweetapp.tweet.Controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.tweetapp.tweet.exception.TweetException;
import com.tweetapp.tweet.payloads.TweetByUser;
import com.tweetapp.tweet.payloads.TweetDto;
import com.tweetapp.tweet.service.ITweetService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TweetControllerTest {
	@Mock
	private ITweetService iTweetService;
	
	@InjectMocks
	private TweetController tweetController; 
	
	@Test
	public void postTweetTest()
	{
		TweetDto dto=new TweetDto();
		when(iTweetService.createTweet(Mockito.any(), Mockito.any())).thenReturn(dto);
		tweetController.postTweet("test", dto);
	}
	
	@Test
	public void getAllTweetTest()
	{
		ArrayList<TweetByUser> list=new ArrayList<TweetByUser>();
		when(iTweetService.getalltweetbyuser(Mockito.anyString())).thenReturn(list);
		ArrayList<TweetByUser> list2=tweetController.getAllTweetByUser("test");
		Assertions.assertNotNull(list2);
	}
	
	@Test
	public void updateTweetTest() throws TweetException
	{
		TweetDto tweetDto=new TweetDto();
		when(iTweetService.updateTweet(tweetDto, 0, null)).thenReturn(tweetDto);
		Assertions.assertNotNull(tweetController.updateTweet(null, 0, tweetDto));
	}
	@Test
	public void updateTweetTest2() throws TweetException
	{
		TweetDto tweetDto=new TweetDto();
		when(iTweetService.updateTweet(tweetDto, 0, null)).thenThrow(TweetException.class);
		Assertions.assertNotNull(tweetController.updateTweet(null, 0, tweetDto));
	}
	
	@Test
	public void deletTweetTest() throws TweetException
	{
		when(iTweetService.deletPost(0, "test")).thenReturn("test");
		Assertions.assertNotNull(tweetController.deletTweet("test", 0));
	}
	@Test
	public void deletTweetTest1() throws TweetException
	{
		when(iTweetService.deletPost(0, "test")).thenThrow(TweetException.class);
		Assertions.assertNotNull(tweetController.deletTweet("test", 0));
	}
	
	@Test 
	public void getallTweetTest()
	{
		List<TweetByUser> list =new ArrayList<TweetByUser>();
		when(iTweetService.getalltweets()).thenReturn(list);
		Assertions.assertNotNull(tweetController.getallTweet());
	}
}
