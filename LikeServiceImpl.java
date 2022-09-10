package com.tweetapp.tweet.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tweetapp.tweet.entity.Like;
import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.payloads.GetAlllikes;
import com.tweetapp.tweet.repo.LikeRepo;
import com.tweetapp.tweet.repo.TweetRepo;
import com.tweetapp.tweet.service.ILikeService;
@Service
@CrossOrigin
public class LikeServiceImpl implements ILikeService {

	@Autowired
	private LikeRepo likeRepo;
	@Autowired 
	private TweetRepo tweetrepo;
	@Override
	public Like addlike(int id, String username) {
 
		Optional<Tweet> tweet=tweetrepo.findById(id);
		
		Like like=new Like();
		System.out.println(tweet);
		if(tweet.isPresent())
		{
		like.setTweet(tweet.get());
		}
		like.setUsername(username);
		return likeRepo.save(like);
		}
	@Override
	public GetAlllikes getallLikes(int id, String username) {
		GetAlllikes getallLikes=new GetAlllikes();
 
		Optional<Tweet> tweet=tweetrepo.findById(id);
		if(tweet.isPresent()) {
		List<Like> listLikes=likeRepo.findBytweet(tweet.get());
		
		getallLikes.setCount(listLikes.size());
		
		int flag=0;
		for (Like like : listLikes) {
			if(like.getUsername().equals(username))
			{
				getallLikes.setUserLiked(true);
				flag=1;
			}
		}
		if(flag==0)
		{
			getallLikes.setUserLiked(false);
		}
		return getallLikes;
		}
		return null;
	}
	
	public String deleteallLikes(Tweet tweet)
	{
		List<Like> likeList=likeRepo.findBytweet(tweet);
		if(likeList.size()>0)
		{
			likeRepo.deleteAll(likeList);
			return "Done";
		}
		return "No Likes";
	}

}
