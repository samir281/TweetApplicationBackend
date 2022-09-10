package com.tweetapp.tweet.serviceimpl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.tweetapp.tweet.entity.Like;
import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.repo.LikeRepo;
import com.tweetapp.tweet.repo.TweetRepo;
import com.tweetapp.tweet.service.impl.CommentServiceImpl;
import com.tweetapp.tweet.service.impl.LikeServiceImpl;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

public class LikeServiceImplTest {
	@Mock
	LikeRepo likeRepo;
	
	@Mock 
	TweetRepo tweetRepo;
	
	@InjectMocks
	LikeServiceImpl likeServiceImpl;
	
	@Test
	public void addlikeTest()
	{
		Tweet tweet=new Tweet();
		tweet.setComments(null);
		tweet.setDate(null);
		tweet.setDescription("test");
		tweet.setId(1);
		tweet.setLike(null);
		tweet.setUser(null);
		when(tweetRepo.findById(tweet.getId())).thenReturn(Optional.of(tweet));
		Like like=new Like();
		when(likeRepo.save(Mockito.any())).thenReturn(like);
		Assertions.assertNotNull(likeServiceImpl.addlike(1, null));
	}
	
	@Test
	public void GetAlllikesTest()
	{
		Tweet tweet=new Tweet();
		tweet.setId(1);
		tweet.setDate(new Date());
		tweet.setComments(null);
		tweet.setDescription("test");
		tweet.setLike(null);
		tweet.setUser(null);
		when(tweetRepo.findById(1)).thenReturn(Optional.of(tweet));
		Like like=new Like();
		like.setId(1);
		like.setUsername("test");
		List<Like> listLike=new ArrayList<Like>();
		listLike.add(like);
		when(likeRepo.findBytweet(Optional.of(tweet).get())).thenReturn(listLike);
		Assertions.assertNotNull(likeServiceImpl.getallLikes(1, "test"));
	}
	
	@Test
	public void GetAlllikesTest1()
	{
		Tweet tweet=new Tweet();
		tweet.setId(1);
		tweet.setDate(new Date());
		tweet.setComments(null);
		tweet.setDescription("test");
		tweet.setLike(null);
		tweet.setUser(null);
		when(tweetRepo.findById(1)).thenReturn(Optional.of(tweet));
		Like like=new Like();
		like.setId(1);
		like.setUsername("test");
		List<Like> listLike=new ArrayList<Like>();
		listLike.add(like);
		when(likeRepo.findBytweet(Optional.of(tweet).get())).thenReturn(listLike);
		Assertions.assertNotNull(likeServiceImpl.getallLikes(1, "test1"));
	}
	
	@Test
	public void GetAlllikesTest2()
	{
		Tweet tweet=new Tweet();
		tweet.setId(1);
		tweet.setDate(new Date());
		tweet.setComments(null);
		tweet.setDescription("test");
		tweet.setLike(null);
		tweet.setUser(null);
		when(tweetRepo.findById(1)).thenReturn(Optional.of(tweet));
		Like like=new Like();
		like.setId(1);
		like.setUsername("test");
		List<Like> listLike=new ArrayList<Like>();
		listLike.add(like);
		when(likeRepo.findBytweet(Optional.of(tweet).get())).thenReturn(listLike);
		Assertions.assertNull(likeServiceImpl.getallLikes(0, "test1"));
	}
	
	@Test
	public void DeletAllLikesTest()
	{
		Like like=new Like();
		like.setId(0);
		like.setTweet(null);
		like.setUsername("test");
		List<Like> likeList=new ArrayList<Like>();
		likeList.add(like);
		when(likeRepo.findBytweet(Mockito.any())).thenReturn(likeList);
//		when(likeRepo.deleteAll(Mockito.anyList()));
		likeServiceImpl.deleteallLikes(Mockito.any());
	}
	@Test
	public void DeletAllLikesTest2()
	{
		List<Like> likeList=new ArrayList<Like>();
		when(likeRepo.findBytweet(Mockito.any())).thenReturn(likeList);
		likeServiceImpl.deleteallLikes(Mockito.any());
	}
}
