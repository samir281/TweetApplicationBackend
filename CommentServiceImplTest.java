package com.tweetapp.tweet.serviceimpl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;

import com.tweetapp.tweet.entity.Comment;
import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.payloads.CommentDto;
import com.tweetapp.tweet.payloads.GetallComment;
import com.tweetapp.tweet.repo.CommentRepo;
import com.tweetapp.tweet.repo.TweetRepo;
import com.tweetapp.tweet.repo.UserRepo;
import com.tweetapp.tweet.service.impl.CommentServiceImpl;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CommentServiceImplTest {
	@Mock
	public TweetRepo tweetrepo;
	@Mock
	UserRepo userrepo;
	@Mock
	public CommentRepo commentRepo;
	
	@InjectMocks
	CommentServiceImpl commentServiceImpl;
	
	@Test
	public void replyToTweetTest()
	{
		CommentDto commentDto=new CommentDto();
		commentDto.setReply("test");
		Tweet tweet=Mockito.mock(Tweet.class);
		tweet.setComments(null);
		tweet.setDate(null);
		tweet.setDescription("test");
		tweet.setId(1);
		tweet.setLike(null);
		tweet.setUser(null);
		when(tweetrepo.findById(1)).thenReturn(Optional.of(tweet));
		System.out.println(Optional.of(tweet).isPresent());
		Comment comment=new Comment();
		when(commentRepo.save(comment)).thenReturn(comment);
		String s=commentServiceImpl.replyToTweet(commentDto, null, 1);
	}
	
	@Test
	public void replyToTweetTest2()
	{
		CommentDto commentDto=new CommentDto();
		commentDto.setReply("test");
		Tweet tweet=Mockito.mock(Tweet.class);
		tweet.setComments(null);
		tweet.setDate(null);
		tweet.setDescription("test");
		tweet.setId(1);
		tweet.setLike(null);
		tweet.setUser(null);
		when(tweetrepo.findById(1)).thenReturn(Optional.of(tweet));
		System.out.println(Optional.of(tweet).isPresent());
		Comment comment=new Comment();
		when(commentRepo.save(comment)).thenReturn(comment);
		String s=commentServiceImpl.replyToTweet(commentDto, null, 0);
	}

	
	@Test
	public void getallcommentTest()
	{
		Tweet tweet2=new Tweet();
		Tweet tweet=Mockito.mock(Tweet.class);
		when(tweetrepo.findById(0)).thenReturn(Optional.<Tweet>of(tweet));
		List<Comment> listComment=new ArrayList<Comment>();
		Comment comment=new Comment();
		comment.setDate(null);
		comment.setId(1);
		comment.setReply("test");
		comment.setTweet(tweet);
		comment.setUserName("test");
		listComment.add(comment); 
		System.out.println(listComment.size());
		when(commentRepo.findAllBytweet(Optional.<Tweet>of(tweet))).thenReturn(listComment);
		List<GetallComment>list=commentServiceImpl.getallcomment(0);
//		System.out.println(list.get(0).getId());
	}

	@Test
	public void deleteallCommentTest()
	{
		List<Comment> listComment=new ArrayList<Comment>();
		List<Comment> listComment2=new ArrayList<Comment>();
		Comment comment=new Comment();
		listComment.add(comment);
		Tweet tweet=Mockito.mock(Tweet.class);
		when(commentRepo.findAllBytweet(tweet)).thenReturn(listComment).thenReturn(listComment2);
		verify(commentRepo,times(0)).deleteAll(listComment);
		commentServiceImpl.deleteallComment(tweet);
	}
	@Test
	public void deleteallCommentTest2()
	{
		List<Comment> listComment2=new ArrayList<Comment>();
		Comment comment=new Comment();
		Tweet tweet=Mockito.mock(Tweet.class);
		when(commentRepo.findAllBytweet(tweet)).thenReturn(listComment2);
		verify(commentRepo,times(0)).deleteAll(listComment2);
		commentServiceImpl.deleteallComment(tweet);
	}
	@Test
	public void getallcommentTest1()
	{
		Tweet tweet2=new Tweet();
		Tweet tweet=Mockito.mock(Tweet.class);
		when(tweetrepo.findById(0)).thenReturn(Optional.<Tweet>of(tweet));
		try {
			commentServiceImpl.getallcomment(0);
		}
		catch(NoSuchElementException e)
		{
			
		}
	}
}
