package com.tweetapp.tweet.payloads;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GetAlllikes {
	
	private int count;
	private boolean userLiked;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isUserLiked() {
		return userLiked;
	}
	public void setUserLiked(boolean userLiked) {
		this.userLiked = userLiked;
	}
	
}
