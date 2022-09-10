package com.tweetapp.tweet.serviceimpl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.exception.TweetException;
import com.tweetapp.tweet.payloads.TweetDto;
import com.tweetapp.tweet.repo.CommentRepo;
import com.tweetapp.tweet.repo.LikeRepo;
import com.tweetapp.tweet.repo.TweetRepo;
import com.tweetapp.tweet.repo.UserRepo;
import com.tweetapp.tweet.service.impl.CommentServiceImpl;
import com.tweetapp.tweet.service.impl.LikeServiceImpl;
import com.tweetapp.tweet.service.impl.TweetServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TweetServiceImplTest {

	@Mock
	TweetRepo tweetRepo;
	
	@Mock
	UserRepo userRepo;
	
	@Mock 
	CommentRepo commentRepo;
	
	@Mock 
	LikeRepo likeRepo;
	
	@InjectMocks
	TweetServiceImpl tweetServiceImpl;
	
	@Test
	public void createTweetTest()
	{
		User user =new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		when(userRepo.findByusername(Mockito.anyString())).thenReturn(user);
		TweetDto tweetDto=new TweetDto();
		tweetDto.setDiscription("test");
		tweetDto.setId(1);
		Tweet tweet=new Tweet();
		tweet.setId(1);
		tweet.setDescription("test");
		when(tweetRepo.save(Mockito.any())).thenReturn(tweet);
		Assertions.assertNotNull(tweetServiceImpl.createTweet(tweetDto, Mockito.anyString()));
	}
	
	@Test
	public void getalltweetbyuserTest()
	{
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setMiddlename("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		user.setUsername("test@test.com");
		user.setTweetJpaList(null);
		when(userRepo.findByusername(Mockito.anyString())).thenReturn(user);
		List<Tweet> listTweet=new ArrayList<Tweet>();
		Tweet tweet=new Tweet();
		tweet.setComments(null);
		tweet.setUser(user);
		tweet.setId(1);
		tweet.setDate(new Date());
		tweet.setDescription("test");
		listTweet.add(tweet);
		when(tweetRepo.findByuser(user)).thenReturn(listTweet);
		Assertions.assertNotNull(tweetServiceImpl.getalltweetbyuser(Mockito.anyString()));
	}
	
	@Test
	public void getalltweetbyuserTest1()
	{
		when(userRepo.findByusername(Mockito.anyString())).thenReturn(null);
		try {
		tweetServiceImpl.getalltweetbyuser(Mockito.anyString());
	}
		catch(NoSuchElementException e)
		{
			
		}
	}
	
	@Test
	public void updateTweetTest() throws TweetException
	{
		TweetDto tweetDto=new TweetDto();
		tweetDto.setDiscription("test");
		tweetDto.setId(1);
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setMiddlename("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		user.setUsername("test@test.com");
		Tweet tweet=new Tweet();
		tweet.setComments(null);
		tweet.setUser(user);
		tweet.setId(1);
		tweet.setDate(new Date());
		tweet.setDescription("test");
		when(tweetRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(tweet));
		when(userRepo.findUserByUsername("test")).thenReturn(Optional.of(user));
		when(tweetRepo.save(Mockito.any())).thenReturn(tweet);
		Assertions.assertNotNull(tweetServiceImpl.updateTweet(tweetDto, Mockito.anyInt(), "test"));
		}
	
	@Test
	public void updateTweetTest2()
	{
		TweetDto tweetDto=new TweetDto();
		tweetDto.setDiscription("test");
		tweetDto.setId(1);
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setMiddlename("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		user.setUsername("test@test.com");
		Tweet tweet=new Tweet();
		tweet.setComments(null);
		tweet.setUser(user);
		tweet.setId(1);
		tweet.setDate(new Date());
		tweet.setDescription("test");
		try {
			tweetServiceImpl.updateTweet(tweetDto, Mockito.anyInt(), "test");
		} catch (TweetException e) {
			e.printStackTrace();
		}
		}
	

	@Test
	public void updateTweetTest3()
	{
		TweetDto tweetDto=new TweetDto();
		tweetDto.setDiscription("test");
		tweetDto.setId(1);
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setMiddlename("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		user.setUsername("test@test.com");
		Tweet tweet=new Tweet();
		tweet.setComments(null);
		tweet.setUser(user);
		tweet.setId(1);
		tweet.setDate(new Date());
		tweet.setDescription("test");
		when(tweetRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(tweet));
		try {
			tweetServiceImpl.updateTweet(tweetDto, Mockito.anyInt(), "test");
		} catch (TweetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateTweetTest4() throws TweetException
	{
		TweetDto tweetDto=new TweetDto();
		tweetDto.setDiscription("test");
		tweetDto.setId(1);
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setMiddlename("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		user.setUsername("test@test.com");
		Tweet tweet=new Tweet();
		tweet.setComments(null);
		tweet.setUser(user);
		tweet.setId(1);
		tweet.setDate(new Date());
		tweet.setDescription("test");
		when(tweetRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(tweet));
		when(userRepo.findUserByUsername("test")).thenReturn(Optional.of(user));
		when(tweetRepo.save(Mockito.any())).thenThrow(new RuntimeException("Exception"));
		Assertions.assertNotNull(tweetServiceImpl.updateTweet(tweetDto, Mockito.anyInt(), "test"));
		}
	
	@Test
	public void updateTweetTest5() throws TweetException
	{
		TweetDto tweetDto=new TweetDto();
		tweetDto.setDiscription("test");
		tweetDto.setId(1);
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setMiddlename("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		user.setUsername("test@test.com");
		Tweet tweet=new Tweet();
		tweet.setComments(null);
		User user2=new User();
		user2.setUsername("test");
		tweet.setUser(user2);
		tweet.setId(1);
		tweet.setDate(new Date());
		tweet.setDescription("test");
		when(tweetRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(tweet));
		when(userRepo.findUserByUsername("test")).thenReturn(Optional.of(user));
//		when(tweetRepo.save(Mockito.any())).thenReturn(tweet);
		Assertions.assertThrows(TweetException.class,()->tweetServiceImpl.updateTweet(tweetDto, Mockito.anyInt(), "test"));
		}
	
	@Test
	public void getalltweetsTest()
	{
		User user=new User();
		user.setFirstname("test");
		user.setId(1);
		user.setLastName("test");
		user.setMiddlename("test");
		user.setPassword("test");
		user.setPhoneNumber("0987654321");
		user.setUsername("test@test.com");
		Tweet tweet=new Tweet();
		tweet.setComments(null);
		tweet.setUser(user);
		tweet.setId(1);
		tweet.setDate(new Date());
		tweet.setDescription("test");
		List<Tweet> listTweet=new ArrayList<Tweet>();
		listTweet.add(tweet);
		when(tweetRepo.findAll()).thenReturn(listTweet);
		Assertions.assertNotNull(tweetServiceImpl.getalltweets());
	}
	
	@Mock
	CommentServiceImpl commentServiceImpl;
	@Mock 
	LikeServiceImpl likeServiceImpl;
	
	@Test
	public void deletpostTest() throws TweetException
	{
		Tweet tweet=new Tweet();
		tweet.setId(1);
		tweet.setDescription("test");
		when(tweetRepo.findById(1)).thenReturn(Optional.of(tweet));
		when(commentServiceImpl.deleteallComment(Optional.of(tweet).get())).thenReturn("done");
		when(likeServiceImpl.deleteallLikes(Optional.of(tweet).get())).thenReturn("done");
		Assertions.assertEquals("Done",tweetServiceImpl.deletPost(1, "test"));
	}
	@Test
	public void deletpostTest1() throws TweetException
	{
		Tweet tweet=new Tweet();
		tweet.setId(1);
		tweet.setDescription("test");
		Assertions.assertEquals("Not Done",tweetServiceImpl.deletPost(1, "test"));
	}
}
