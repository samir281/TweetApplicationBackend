package com.tweetapp.tweet.service;

import com.tweetapp.tweet.entity.Like;
import com.tweetapp.tweet.payloads.GetAlllikes;

public interface ILikeService {
	public GetAlllikes getallLikes(int id,String username);
	public Like addlike(int id,String username);
}
