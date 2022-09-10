package com.tweetapp.tweet.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tweetapp.tweet.exception.CommentException;
import com.tweetapp.tweet.exception.TweetException;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
@ControllerAdvice
public class Advice {

	@ExceptionHandler(TweetException.class)
	
	public ResponseEntity<String> handleTweetException(TweetException tweetException){
		return new ResponseEntity<String>(tweetException.getMessage(),HttpStatus.BAD_REQUEST);
	}
@ExceptionHandler(NoSuchElementException.class)
	
	public ResponseEntity<String> handleException(NoSuchElementException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
@ExceptionHandler(CommentException.class)
public ResponseEntity<String> handleCommentException(CommentException commentException)
{
	return new ResponseEntity<String>(commentException.getMessage(),HttpStatus.NOT_FOUND);
}
}
