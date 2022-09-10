package com.tweetapp.tweet.Controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.tweetapp.tweet.entity.Like;
import com.tweetapp.tweet.payloads.GetAlllikes;
import com.tweetapp.tweet.service.ILikeService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)


public class LikeControllerTest {
	
	@Mock
	private ILikeService iLikeService;
	
	@InjectMocks
	LikeController controller;
	
	@Test
	public void updateLikeTest()
	{
		Like like=new Like();
		when(iLikeService.addlike(0, null)).thenReturn(like);
		Assertions.assertNotNull(controller.updateLike(null, 0));
	}
	
	@Test
	public void getallLikesTest()
	{
		GetAlllikes alllikes=new GetAlllikes();
		when(iLikeService.getallLikes(0, null)).thenReturn(alllikes);
		Assertions.assertNotNull(controller.getallLikes(null, 0));
	}
}
