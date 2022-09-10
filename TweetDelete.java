package com.tweetapp.tweet.payloads;

import lombok.NoArgsConstructor;

 
@NoArgsConstructor
public class TweetDelete {
	
	String username;
	int tweetId;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTweetId() {
		return tweetId;
	}
	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

}
