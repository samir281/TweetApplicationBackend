package com.tweetapp.tweet.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.tweet.exception.TweetException;
import com.tweetapp.tweet.payloads.TweetByUser;
import com.tweetapp.tweet.payloads.TweetDto;
import com.tweetapp.tweet.service.ITweetService;
@RestController
@CrossOrigin
public class TweetController implements ITweetController {
	
	@Autowired
	private ITweetService iTweetService;
	
	@Override
	public ResponseEntity<TweetDto> postTweet(String username, @Valid TweetDto tweetDto) {
		 
		TweetDto response=iTweetService.createTweet(tweetDto, username);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}


	@Override
	public ArrayList<TweetByUser> getAllTweetByUser(String username) {
	 
		return iTweetService.getalltweetbyuser(username);
	}

	@Override
	public ResponseEntity<TweetDto> updateTweet(String username, int tweetid,TweetDto tweetDto){
		 
		try {
		TweetDto response=iTweetService.updateTweet(tweetDto, tweetid,username);
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
		catch (TweetException e) {
			TweetDto tweetDto2=new TweetDto();
			tweetDto2.setDiscription(e.getMessage());
			return new ResponseEntity<>(tweetDto2,HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> deletTweet(String username, int tweetid){
		 
		try {
		String response=iTweetService.deletPost(tweetid,username);
		return new ResponseEntity<String>(response,HttpStatus.OK);
		}
		catch (TweetException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}


	@Override
	public ResponseEntity<?> getallTweet() {
	 
		List<TweetByUser> tweetList=iTweetService.getalltweets();
		return new ResponseEntity<>(tweetList,HttpStatus.OK);
	}
}
