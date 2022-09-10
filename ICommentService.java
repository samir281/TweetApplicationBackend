package com.tweetapp.tweet.service;

import java.util.List;

import com.tweetapp.tweet.payloads.CommentDto;
import com.tweetapp.tweet.payloads.GetallComment;

public interface ICommentService {
	
	//String replyToTweet(CommentDto commentDto) throws TweetException;

	String replyToTweet(CommentDto commentDto, String username,int id);
	List<GetallComment> getallcomment(int id);
	
}
